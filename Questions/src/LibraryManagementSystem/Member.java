package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member {
    private final String id;
    private final String name;
    private final String contactInfo;
    private final List<Loan> activeLoans = new ArrayList<>();

    // for now store only book details
    private final List<Loan> loanHistory = new ArrayList<>();

    public Member(String name, String contactInfo) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public synchronized List<Loan> getActiveLoans() {
        return activeLoans;
    }

    // When a new loan is created
    public synchronized void addLoan(Loan loan) {
        activeLoans.add(loan);
        loanHistory.add(loan); // add to history
    }

    // When a loan is returned
    public synchronized void removeLoan(Loan loan) {
        activeLoans.remove(loan);
    }

    public List<Loan> getHistory() {
        return loanHistory;
    }
}