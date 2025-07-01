package HotelManagementSystem.Services;

import HotelManagementSystem.Room;
import HotelManagementSystem.RoomStatus;
import HotelManagementSystem.RoomType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Manages rooms: availability, lookup, assignment, and release
public class RoomManager {
    // All rooms by number
    private final Map<String, Room> rooms = new ConcurrentHashMap<>();

    public void addRoom(Room room) {
        rooms.put(room.getNumber(), room);
    }

    // Find available rooms of a given type for the date range.
    // A room is available if its status is AVAILABLE.
    public synchronized List<Room> findAvailable(RoomType type, LocalDate checkIn, LocalDate checkOut) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.getType() == type && room.getStatus() == RoomStatus.AVAILABLE) {
                result.add(room);
            }
        }
        return result;
    }

    // Mark a room as occupied
    public synchronized void assignRoom(Room room) {
        room.setStatus(RoomStatus.OCCUPIED);
    }

    // Release a room (set to AVAILABLE)
    public synchronized void releaseRoom(Room room) {
        room.setStatus(RoomStatus.AVAILABLE);
    }
}