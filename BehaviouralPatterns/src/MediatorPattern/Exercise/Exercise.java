// This class simulates the flight control system, managing airplane takeoff and landing requests through a control tower mediator.

package MediatorPattern.Exercise;

import java.util.Scanner;

public class Exercise {

    // Do not modify the run method. It demonstrates the functionality of the Flight Control System using the Mediator design pattern.
    public void run() {
        
        Scanner sc = new Scanner(System.in);
        
        ControlTower controlTower = new ControlTower();
        
        String airplaneId1 = sc.nextLine();
        String airplaneId2 = sc.nextLine();
        String airplaneId3 = sc.nextLine();
        String airplaneId4 = sc.nextLine();
        
        // TODO: Instantiate an airplane with the first provided ID
        Airplane airplane1 = new Airplane(airplaneId1);
        
        // TODO: Instantiate an airplane with the second provided ID
        Airplane airplane2 = new Airplane(airplaneId2);
        
        // TODO: Instantiate an airplane with the third provided ID
        Airplane airplane3 = new Airplane(airplaneId3);
        
        // TODO: Instantiate an airplane with the fourth provided ID
        Airplane airplane4 = new Airplane(airplaneId4);
    
        // TODO: Register the first airplane with the control tower
        controlTower.registerAirplane(airplane1);
        
        // TODO: Register the second airplane with the control tower
        controlTower.registerAirplane(airplane2);
        
        // TODO: Register the third airplane with the control tower
        controlTower.registerAirplane(airplane3);
        
        // TODO: Register the fourth airplane with the control tower
        controlTower.registerAirplane(airplane4);

        airplane1.requestTakeoff();
        airplane2.requestTakeoff();
        airplane3.requestTakeoff();
        airplane4.requestTakeoff();
        
        // TODO: Mark the first airplane as having completed takeoff and free a runway
        controlTower.completeTakeoff(airplane1);
        
        // TODO: Mark the second airplane as having completed takeoff and free a runway
        controlTower.completeTakeoff(airplane2);

        airplane3.requestTakeoff();
        airplane4.requestTakeoff();
        
        // TODO: Mark the third airplane as having completed takeoff and free a runway
        controlTower.completeTakeoff(airplane3);
        
        // TODO: Mark the fourth airplane as having completed takeoff and free a runway
        controlTower.completeTakeoff(airplane4);

        airplane1.requestLanding();
        airplane2.requestLanding();
        
        // TODO: Mark the first airplane as having completed landing and free a runway
        controlTower.completeLanding(airplane1);
        
        // TODO: Mark the second airplane as having completed landing and free a runway
        controlTower.completeLanding(airplane2);
        
        airplane3.requestLanding();
        airplane4.requestLanding();
        
        // TODO: Mark the third airplane as having completed landing and free a runway
        controlTower.completeLanding(airplane3);
        
        // TODO: Mark the fourth airplane as having completed landing and free a runway
        controlTower.completeLanding(airplane4);
        

        sc.close();
    }
}