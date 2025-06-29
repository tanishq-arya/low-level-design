package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Manages all branches and their cars
public class BranchManager {
    private final Map<String, Branch> branches = new ConcurrentHashMap<>();

    public void addBranch(Branch branch) {
        branches.put(branch.getId(), branch);
    }

    public Branch getBranch(String branchId) {
        return branches.getOrDefault(branchId, null);
    }

    // Find available cars in a branch matching type and date range.
    // Assumes ReservationManager has already checked availability.
    public List<Car> listCars(String branchId) {
        return new ArrayList<>(getBranch(branchId).getCars());
    }
}