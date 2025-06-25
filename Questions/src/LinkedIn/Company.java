package LinkedIn;

public class Company {
    private final String id;
    private String name;
    private String email;
    private String description;

    public Company(String id, String name, String email, String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
    }
}