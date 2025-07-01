package HotelManagementSystem.Services;

import HotelManagementSystem.Reservation;
import HotelManagementSystem.ReservationStatus;
import HotelManagementSystem.Room;
import HotelManagementSystem.RoomType;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

public class ReportingService {
    private final RoomManager roomManager;
    private final ReservationManager reservationManager;

    public ReportingService(RoomManager roomManager, ReservationManager reservationManager) {
        this.roomManager = roomManager;
        this.reservationManager = reservationManager;
    }

    // Returns occupancy rate (0.0–1.0) per room type for current date.
    // Occupancy rate for each type > (#occupied / #total)
    public Map<RoomType, Double> occupancyByType(LocalDate date) {
        Map<RoomType, Integer> totalByType = new EnumMap<>(RoomType.class);
        Map<RoomType, Integer> occupiedByType = new EnumMap<>(RoomType.class);

        // initialize counts
        for (RoomType type : RoomType.values()) {
            totalByType.put(type, 0);
            occupiedByType.put(type, 0);
        }

        // count all rooms
        for (Room room : roomManager.findAvailable(null, null, null)) {
            totalByType.merge(room.getType(), 1, Integer::sum);
        }

        // count occupied rooms via reservations
        for (Reservation r : reservationManager.getReservations().values()) {
            if (r.getStatus() == ReservationStatus.CHECKED_IN) {
                RoomType type = r.getRoom().getType();
                occupiedByType.put(type, occupiedByType.get(type)+1);
                totalByType.put(type, totalByType.get(type)+1); // ensure total includes occupied
            }
        }

        // compute rates
        Map<RoomType, Double> rates = new EnumMap<>(RoomType.class);
        for (RoomType type : RoomType.values()) {
            int total = totalByType.get(type);
            int occ = occupiedByType.get(type);
            rates.put(type, total == 0 ? 0.0 : (double) occ / total);
        }
        return rates;
    }
}