package CarRentalSystem;

import java.time.LocalDate;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // Initialize service
        CarRentalService service = new CarRentalService();

        // Create branch & cars
        Branch b1 = new Branch("B1", "Downtown");
        Car c1 = new Car("C1", "Toyota", "Camry", 2020, "XYZ123", 50, CarType.SEDAN);
        Car c2 = new Car("C2", "Honda", "CRV", 2021, "ABC789", 70, CarType.SUV);
        b1.addCar(c1);
        b1.addCar(c2);
        service.addBranch(b1);

        // Create customer
        Customer alice = new Customer("U1", "Alice", "alice@example.com", "D1234");

        // Search
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        List<Car> available = service.searchCars("B1", today, tomorrow, CarType.SEDAN, 40, 60);
        System.out.println("Available sedans: " + available.size());  // expect 1

        // Reserve
        Reservation r = service.createReservation("B1", "C1", alice, today, tomorrow, 100);
        System.out.println("Reservation created: " + r.getId());

        // Modify (extend by 1 day)
        service.modifyReservation(r.getId(), today, tomorrow.plusDays(1), 50);

        // Cancel
        service.cancelReservation(r.getId());
    }
}