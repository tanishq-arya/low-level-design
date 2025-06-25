package LinkedIn;

import java.util.UUID;

public class JobPost {
    private final String id;
    private String title;
    private String description;
    private final User company;
    private final long postedAt;

    public JobPost(String title, String description, User company) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.company = company;
        this.postedAt = System.currentTimeMillis();
    }

    public User getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }
}