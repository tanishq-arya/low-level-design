package RestaurantManagementSystem;

import java.time.LocalDateTime;

public class Report {
    private final String title;
    private final LocalDateTime generatedAt;
    private final String content;

    public Report(String title, String content) {
        this.title = title;
        this.generatedAt = LocalDateTime.now();
        this.content = content;
    }

    public String getTitle() { return title; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public String getContent() { return content; }

    @Override
    public String toString() {
        return "Report: " + title + "\n" +
                "Generated: " + generatedAt + "\n\n" +
                content;
    }
}