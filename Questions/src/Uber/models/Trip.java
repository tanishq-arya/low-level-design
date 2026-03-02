package Uber.models;

import Uber.enums.TripStatus;

import java.time.LocalDateTime;

public class Trip {
    String id;
    String riderId, driverId;
    Location pickup, drop;
    TripStatus status;
    double fare;
    LocalDateTime startTime, endTime;
}
