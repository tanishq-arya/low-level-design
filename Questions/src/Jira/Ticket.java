package Jira;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ticket {
    String id, title, description;

    Status status;
    Priority priority;

    User reporter, assignee;

    List<Comment> comments = new ArrayList<>();

    public Ticket(String title, String description) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
    }

    void assign(User user) {
        this.assignee = user;
    }

    void updateStatus(Status status) {
        this.status = status;
    }

    void addComment(Comment comment) {
        comments.add(comment);
    }

    public String getId() {return id;}
}
