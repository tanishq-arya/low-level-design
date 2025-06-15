package V2;

// Abstract > because we don't want to create objects of this class
abstract class User {
    // Common properties b/w driver and passenger

    protected String name;
    protected String email;
    protected Location location;

    public User(String name, String email, Location location) {
        this.name = name;
        this.email = email;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract void notify(String msg);
}