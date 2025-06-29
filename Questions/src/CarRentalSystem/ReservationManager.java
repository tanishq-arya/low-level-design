package CarRentalSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/// Manages reservations and enforces availability.
public class ReservationManager {
    /// Map<carId, List<Reservation>>
    private final Map<String, List<Reservation>> reservationsByCar = new ConcurrentHashMap<>();

    /// Create a new reservation if the car is available for the given dates.
    public synchronized Reservation createReservation(Customer customer, Branch branch, Car car, LocalDate start, LocalDate end) {
        // Check availability
        List<Reservation> list = reservationsByCar
                .computeIfAbsent(car.getId(), id -> new ArrayList<>());

        // Check if the reservation list for car overlaps with current
        for (Reservation r : list) {
            if (overlaps(r.getStartDate(), r.getEndDate(), start, end)) {
                throw new RuntimeException("Car not available for selected dates");
            }
        }

        // Reserve
        Reservation reservation = new Reservation(car, customer, branch, start, end);
        list.add(reservation);
        car.setStatus(CarStatus.RESERVED);

        return reservation;
    }

    /// Modify dates of an existing reservation.
    public synchronized void modifyReservation(String reservationId,
                                               LocalDate newStart,
                                               LocalDate newEnd) {
        Reservation reservation = findById(reservationId);
        // Remove from list temporarily
        List<Reservation> list = reservationsByCar.get(reservation.getCar().getId());
        list.remove(reservation);

        // Check new availability
        for (Reservation r : list) {
            if (overlaps(r.getStartDate(), r.getEndDate(), newStart, newEnd)) {
                // Put it back then error
                list.add(reservation);
                throw new RuntimeException("New dates conflict with existing reservation");
            }
        }

        // Update
        reservation.setStartDate(newStart);
        reservation.setEndDate(newEnd);
        list.add(reservation);
    }

    /// Cancel a reservation and apply penalty if needed.
    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = findById(reservationId);
        reservation.setStatus(ReservationStatus.CANCELLED);
        // Refund logic omitted; could integrate PaymentManager

        // Free up car
        reservation.getCar().setStatus(CarStatus.AVAILABLE);
    }

    /// Find reservation by ID across all cars.
    Reservation findById(String reservationId) {
        return reservationsByCar.values().stream()
                .flatMap(List::stream)
                .filter(r -> r.getId().equals(reservationId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    private boolean overlaps(LocalDate startDate, LocalDate endDate, LocalDate start, LocalDate end) {
        return !startDate.isAfter(end) && !start.isAfter(endDate);
    }
}