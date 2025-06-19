package ATM;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CashInventory {
    private final Map<Integer, Integer> notes = new ConcurrentHashMap<>();
    public CashInventory() {
        for (int denomination : new int[]{1000, 500, 200, 100, 50, 20, 10}) {
            notes.put(denomination, 10);
        }
    }
    public synchronized boolean hasCash(int denomination) {
        return notes.getOrDefault(denomination, 0) > 0;
    }
    public synchronized boolean dispenseNote(int denomination) {
        int count = notes.getOrDefault(denomination, 0);
        if (count > 0) {
            notes.put(denomination, count - 1);
            return true;
        }
        return false;
    }
    public synchronized void acceptDeposit(double amount) {
        // simplify: treat deposit as cash accepted into 100s
        notes.put(100, notes.getOrDefault(100, 0) + (int)(amount / 100));
    }
}