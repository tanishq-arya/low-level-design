package HotelManagementSystem;

import HotelManagementSystem.PaymentMethodStrategy.PaymentMethod;
import HotelManagementSystem.Services.BillingService;
import HotelManagementSystem.Services.ReportingService;
import HotelManagementSystem.Services.ReservationManager;
import HotelManagementSystem.Services.RoomManager;

import java.time.LocalDate;
import java.util.Map;

// Facade, can be made Singleton too
public class HotelService {
    private final RoomManager roomManager = new RoomManager();
    private final ReservationManager reservationManager = new ReservationManager(roomManager);
    private final BillingService billingService = new BillingService();
    private final ReportingService reportingService = new ReportingService(roomManager, reservationManager);

    // Register a room (initial)
    public void registerRoom(Room room) {
        roomManager.addRoom(room);
    }

    // Book a room
    public Reservation bookRoom(Guest guest, RoomType type, LocalDate checkIn, LocalDate checkOut) {
        return reservationManager.createReservation(guest, type, checkIn, checkOut);
    }

    // Check‑in
    public void checkIn(String reservationId) {
        reservationManager.checkIn(reservationId);
    }

    // Check‑out
    public void checkOut(String reservationId) {
        reservationManager.checkOut(reservationId);
    }

    // Make payment
    public Payment pay(String reservationId, PaymentMethod method) {
        Reservation reservation = reservationManager.getReservation(reservationId);
        return billingService.collectPayment(reservation, method);
    }

    // Generate occupancy report for today
    public Map<RoomType, Double> reportOccupancy() {
        return reportingService.occupancyByType(LocalDate.now());
    }
}