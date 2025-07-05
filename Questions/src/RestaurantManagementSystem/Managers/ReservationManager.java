package RestaurantManagementSystem.Managers;

import RestaurantManagementSystem.Customer;
import RestaurantManagementSystem.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationManager {
    private final Map<String, Reservation> reservations = new ConcurrentHashMap<>();

    public synchronized Reservation create(Customer customer, LocalDateTime dt, int size) {
        Reservation reservation = new Reservation(customer, dt, size);
        reservations.put(reservation.getId(), reservation);
        return reservation;
    }

    public synchronized void cancel(String id) {
        Reservation reservation = reservations.get(id);
        if (reservation == null) {
            System.out.println("Reservation not found: " + id);
        } else {
            reservation.cancel();
            System.out.println("Reservation CANCELLED: " + id);
        }
    }

    public List<Reservation> reservationList(String customerId) {
        List<Reservation> customerReservations = new ArrayList<>();
        for (Reservation reservation: reservations.values()) {
            if (reservation.getCustomer().getId().equals(customerId)) {
                customerReservations.add(reservation);
            }
        }

        return customerReservations;
    }
}