// This class serves as the mediator, managing communication and runway allocation between airplanes for takeoff and landing.

package MediatorPattern.Exercise;

import java.util.ArrayList;
import java.util.List;

public class ControlTower implements Mediator {
    
    private List<Airplane> airplanes;
    private int takeoffRunways;
    private int landingRunways;

    public ControlTower() {
        // TODO: Initialize the list of airplanes to manage communication
        this.airplanes = new ArrayList<>();
        
        this.takeoffRunways = 2;
        this.landingRunways = 2;
    }

    @Override
    public void registerAirplane(Airplane airplane) {
        // TODO: Add the airplane to the list of registered airplanes
        this.airplanes.add(airplane);
        
        // TODO: Set the mediator for the airplane to enable communication
        airplane.setMediator(this);
        
    }

    @Override
    public void handleTakeoffRequest(Airplane airplane) {
        if (takeoffRunways > 0) {
            takeoffRunways--; 
            notifyAirplane(airplane, "Takeoff approved. Runways available: " + takeoffRunways);
        } else {
            notifyAirplane(airplane, "Takeoff denied. No runways available. Please wait");
        }
    }

    @Override
    public void handleLandingRequest(Airplane airplane) {
        if (landingRunways > 0) {
            landingRunways--;
            notifyAirplane(airplane, "Landing approved. Runways available: " + landingRunways);
        } else {
            notifyAirplane(airplane, "Landing denied. No runways available. Please wait");
        }
    }

    // Simulate the completion of takeoff and free the runway
    public void completeTakeoff(Airplane airplane) {
        System.out.println("Airplane " + airplane.getId() + " has taken off");
        takeoffRunways++;
        System.out.println("Runway freed. Available takeoff runways: " + takeoffRunways);
    }

    // Simulate the completion of landing and free the runway
    public void completeLanding(Airplane airplane) {
        System.out.println("Airplane " + airplane.getId() + " has landed");
        landingRunways++;
        System.out.println("Runway freed. Available landing runways: " + landingRunways);
    }

    private void notifyAirplane(Airplane airplane, String message) {
        // TODO: Notify the airplane of the status message from the control tower
        airplane.receiveNotification(message);
    }
}