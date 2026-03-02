package Uber.models;

import Uber.enums.PaymentStatus;

public class Payment {
    String id, tripId; // FK reference to trip
    double amount;
    PaymentStatus status;
}
