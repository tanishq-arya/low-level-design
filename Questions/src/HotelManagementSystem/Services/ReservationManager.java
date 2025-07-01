package HotelManagementSystem.Services;

import HotelManagementSystem.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Manages reservations, ensuring no double booking
public class ReservationManager {
    // Map reservationId → Reservation
    private final Map<String, Reservation> reservations = new ConcurrentHashMap<>();

    // Map roomNumber → list of reservations for that room
    private final Map<String, List<Reservation>> reservationsByRoom = new ConcurrentHashMap<>();

    private final RoomManager roomManager;

    public ReservationManager(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    // createReservation
    public synchronized Reservation createReservation(Guest guest, RoomType type, LocalDate checkIn, LocalDate checkOut) {
        // find available rooms
        List<Room> availableRooms = roomManager.findAvailable(type, checkIn, checkOut);
        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms of type: " + type);
            return null;
        }

        Room room = availableRooms.getFirst();
        roomManager.assignRoom(room);

        Reservation reservation = new Reservation(guest, room, checkIn, checkOut);
        reservations.put(reservation.getId(), reservation);
        reservationsByRoom
                .computeIfAbsent(room.getNumber(), k -> new ArrayList<>())
                .add(reservation);
        return reservation;
    }

    // Guest checks in: mark reservation and room status
    public synchronized void checkIn(String reservationId) {
        Reservation reservation = getReservation(reservationId);
        if (reservation.getStatus() != ReservationStatus.BOOKED) {
            System.out.println("Cannot check in: status is " + reservation.getStatus());
        }
        reservation.setStatus(ReservationStatus.CHECKED_IN);
        // room already assigned
    }

    // Guest checks out: free room and update status
    public synchronized void checkOut(String reservationId) {
        Reservation reservation = getReservation(reservationId);
        if (reservation.getStatus() != ReservationStatus.CHECKED_IN) {
            System.out.println("Cannot check out: status is " + reservation.getStatus());
        }
        reservation.setStatus(ReservationStatus.CHECKED_OUT);
        roomManager.releaseRoom(reservation.getRoom());
    }

    // Cancel a reservation before check‑in
    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = getReservation(reservationId);
        if (reservation.getStatus() != ReservationStatus.BOOKED) {
            System.out.println("Cannot cancel: status is " + reservation.getStatus());
        }
        reservation.setStatus(ReservationStatus.CANCELLED);
        roomManager.releaseRoom(reservation.getRoom());
    }

    public Reservation getReservation(String reservationId) {
        Reservation reservation = reservations.getOrDefault(reservationId, null);
        if (reservation == null) {
            System.out.println("Reservation not found: reservationId= " + reservationId);
        }
        return reservation;
    }

    public Map<String, Reservation> getReservations() {
        return reservations;
    }
}