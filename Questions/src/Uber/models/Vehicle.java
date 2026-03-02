package Uber.models;

import Uber.enums.VehicleType;

public class Vehicle {
    String id, plateNumber;
    VehicleType type;
    String driverId;  // FK reference
}
