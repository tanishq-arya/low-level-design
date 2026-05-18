package MeetingScheduler;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class MeetingScheduler {
    static class Pair {
        int start, end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Room {
        int id;
        int capacity;
        TreeSet<Pair> bookings; // sorted by start time

        ReentrantLock lock; // V.V.imp.**

        Room(int id, int capacity) {
            this.id = id;
            this.capacity = capacity;
            bookings = new TreeSet<>((a,b) -> a.start - b.start);
            lock = new ReentrantLock();
        }

        public int getId() {
            return id;
        }

        public void addBooking(Pair pair) {
            this.bookings.add(pair);
        }

        public void removeBooking(Pair pair) {
            this.bookings.remove(pair);
        }

        boolean isBooked(int start, int end) { // Time: O(K) => check all intervals
            // bookings = [[1,2] [4, 5]]
            // add [2,3]
            for(Pair p: bookings) { // check all bookings
                if (!(end <= p.start || start >= p.end)) { // overlap
                    return true;
                }
            }
            return false;
        }

        boolean isBookedLog(int start, int end) { // Time: O(2*log(k)) => O(log(k))
            // bookings = [[1,2] [4, 5] [8,10]]
            // add [5,7]               ^ interval here

            Pair p = new Pair(start, end);

            // closest smaller start time => [4, 5]
            Pair floor = bookings.floor(p);
            if (floor != null && floor.end > start) // overlap
                return true;

            // closest larger start time => [8, 10]
            Pair ceil = bookings.ceiling(p);
            if (ceil != null && ceil.start < end) // overlap
                return true;

            return false;
        }
    }

    static class Booking {
        int id;
        int roomId;
        Pair interval;

        Booking(int id, int roomId, Pair interval) {
            this.id = id;
            this.roomId = roomId;
            this.interval = interval;
        }

        public int getId() {
            return id;
        }

        public Pair getInterval() {
            return interval;
        }
    }

    // Mappings
    Map<Integer, Room> rooms;
    Map<Integer, Booking> bookings;
    int count;

    MeetingScheduler() {
        rooms = new HashMap<>();
        bookings = new HashMap<>();
        count = 0; // booking counter
    }

    // Time: O(N * log(k))
    List<Integer> view(int start, int end) {
        // check all rooms * all bookings
        List<Integer> res = new ArrayList<>();

        for(Room room: rooms.values()) { // check N rooms **
            if(!room.isBookedLog(start, end)) {
                res.add(room.getId()); // free => add to result
            }
        }

        return res;
    }

    // Time: O(log(K))
    int book(int roomId, int start, int end) {
        Room room = rooms.get(roomId);
        room.lock.lock();

        try {
            // validate & then book - v.v.imp.**
            if (room.isBookedLog(start, end)) {
                return -1;
            }

            // add interval to room
            room.addBooking(new Pair(start, end));

            // create booking
            Booking booking = new Booking(count++, roomId, new Pair(start, end));
            bookings.put(booking.getId(), booking);

            return booking.getId(); // return id
        } finally {
            room.lock.unlock();
        }
    }

    // Time: O(log(K))
    void cancel(int bookingId) {
        // get booking
        Booking booking = bookings.get(bookingId);
        if (booking == null) return;

        // update booking & room
        Room room = rooms.get(booking.roomId);
        room.lock.lock();

        try {
            // double check inside lock => remove booking
            Booking existing = bookings.remove(bookingId);
            if (existing == null) return;

            room.removeBooking(existing.getInterval()); // remove from room

        } finally {
            room.lock.unlock();
        }
    }

    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler();

        // Create some rooms
        scheduler.rooms.put(1, new Room(1, 10));
        scheduler.rooms.put(2, new Room(2, 20));
        scheduler.rooms.put(3, new Room(3, 15));

        // Book some meetings
        int b1 = scheduler.book(1, 9, 11); // Room 1, 9-11
        int b2 = scheduler.book(2, 10, 12); // Room 2, 10-12
        int b3 = scheduler.book(3, 14, 15); // Room 3, 14-15

        System.out.println("Bookings:");
        System.out.println("Booking ID " + b1 + " in Room 1");
        System.out.println("Booking ID " + b2 + " in Room 2");
        System.out.println("Booking ID " + b3 + " in Room 3");

        // View available rooms for 10-11
        List<Integer> freeRooms = scheduler.view(10, 11);
        System.out.println("\nFree rooms from 10 to 11: " + freeRooms);

        // Attempt an overlapping booking
        int b4 = scheduler.book(1, 10, 12); // Should fail because Room 1 is busy
        System.out.println("\nTrying to book Room 1 from 10-12, got booking ID: " + b4);

        // Cancel a booking
        scheduler.cancel(b1);
        System.out.println("\nCancelled booking ID " + b1);

        // View available rooms for 10-12
        freeRooms = scheduler.view(10, 12);
        System.out.println("\nFree rooms from 10 to 12: " + freeRooms);

        // Try booking again after cancellation
        int b5 = scheduler.book(1, 10, 12); // Should succeed now
        System.out.println("Booking Room 1 from 10-12 after cancellation, got booking ID: " + b5);

        // View available rooms for 10-11 again
        freeRooms = scheduler.view(10, 11);
        System.out.println("\nFree rooms from 10 to 11 now: " + freeRooms);
    }
}
