package CarRentalSystem;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// Facade
public class CarRentalService {
    private final BranchManager branchManager;
    private final ReservationManager reservationManager;
    private final PaymentProcessor paymentProcessor;

    public CarRentalService() {
        this.branchManager = new BranchManager();
        this.reservationManager = new ReservationManager();
        this.paymentProcessor = new PaymentProcessor();
    }

    ///  Search available cars in a branch for given date range and optional filters.
    public List<Car> searchCars(String branchId,LocalDate start,LocalDate end,CarType type,double minRate,double maxRate) {
        return branchManager.listCars(branchId).stream()
                .filter(c -> c.getType() == type)
                .filter(c -> c.getDailyRate() >= minRate && c.getDailyRate() <= maxRate)
                .filter(c -> isAvailable(c, start, end))
                .collect(Collectors.toList());
    }

    private boolean isAvailable(Car car, LocalDate start, LocalDate end) {
        try {
            // Try to create a dummy reservation to test availability
            reservationManager.createReservation(
                    new Customer("test", "", "", ""), // dummy
                    branchManager.getBranch(car.getId()), // use car’s branch
                    car,
                    start,
                    end
            );
            // immediately cancel it
            reservationManager.cancelReservation(car.getId());
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    /// Create a reservation and process payment.
    public Reservation createReservation(String branchId,
                                         String carId,
                                         Customer customer,
                                         LocalDate start,
                                         LocalDate end,
                                         double paymentAmount) {
        Branch branch = branchManager.getBranch(branchId);
        Car car = branch.getCars().stream()
                .filter(c -> c.getId().equals(carId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Car not found"));

        // 1) book reservation
        Reservation reservation = reservationManager.createReservation(
                customer, branch, car, start, end);

        // 2) process payment
        Payment payment = paymentProcessor.processPayment(reservation, paymentAmount);

        // 3) confirm reservation
        reservation.setStatus(ReservationStatus.CONFIRMED);

        return reservation;
    }

    /// Modify an existing reservation’s dates.
    public void modifyReservation(String reservationId,
                                  LocalDate newStart,
                                  LocalDate newEnd,
                                  double additionalPayment) {
        reservationManager.modifyReservation(reservationId, newStart, newEnd);
        // collect any additional payment
        if (additionalPayment > 0) {
            paymentProcessor.processPayment(
                    reservationManager.findById(reservationId),
                    additionalPayment
            );
        }
    }

    /// Cancel reservation with penalty (e.g., 20% fee).
    public void cancelReservation(String reservationId) {
        Reservation reservation = reservationManager.findById(reservationId);
        double penalty = reservation.getTotalCost() * 0.20;
        // refund net amount
        paymentProcessor.refund(reservation.getId());
        reservationManager.cancelReservation(reservationId);
        System.out.println("Cancelled. Penalty charged: " + penalty);
    }

    public void addBranch(Branch branch) {
        branchManager.addBranch(branch);
        System.out.println("Branch added.");
    }
}