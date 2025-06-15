package V2;

public class Passenger extends User{

    public Passenger(String name, String email, Location location) {
        super(name, email, location);
    }

    // other methods ?
    public void notify(String msg) {
        System.out.println("Passenger notified: "  + msg);
    }
}