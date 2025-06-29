package CarRentalSystem;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Branch {
    private final String id;
    private final String location;
    private final List<Car> cars = new CopyOnWriteArrayList<>();

    public Branch(String id, String location) {
        this.id = id;
        this.location = location;
    }

    public String getId() {return id;}
    public String getLocation() {return location;}
    public List<Car> getCars() {return cars;}

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }
}