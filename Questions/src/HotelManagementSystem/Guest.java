package HotelManagementSystem;

import java.util.UUID;

public class Guest {
    private final String id;
    private final String name;
    private final String email;
    private final String idProof;

    public Guest(String name, String email, String idProof) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.idProof = idProof;
    }

    // Getters
    public String getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getIdProof() {return idProof;}
}