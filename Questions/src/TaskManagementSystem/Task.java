package TaskManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Task {
    private String id;
    private String title;
    private String description;
    private Date dueDate;
    private TaskPriority priority;
    private TaskStatus status;
    private User assignee; // current user task is assigned to.
    private User creator; // created by

    // Store linked resources
    private final List<Comment> comments;
    private final List<Reminder> reminders;
    private final List<String> history;

    public Task(String title, String description, Date dueDate, TaskPriority priority, User assignee, User creator) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.assignee = assignee;
        this.creator = creator;
        this.status = TaskStatus.PENDING; // by default

        this.comments = new ArrayList<>();
        this.reminders = new ArrayList<>();
        this.history = new ArrayList<>();

        addHistory("Task Created");
    }

    // Update task
    public synchronized void updateStatus(TaskStatus newStatus) {
        this.status = newStatus;
        addHistory("Status -> " + newStatus);
    }

    public synchronized void updatePriority(TaskPriority newPriority) {
        this.priority = newPriority;
        addHistory("Priority -> " + newPriority);
    }

    public synchronized void assignUser(User user) {
        this.assignee = user;
        addHistory("Assigned to -> " + user.name());
    }

    public synchronized void addComment(Comment comment) {
        comments.add(comment);
        addHistory("Comment added by " + comment.getAuthor().name());
    }

    public synchronized void addReminder(Reminder reminder) {
        reminders.add(reminder);
        addHistory("Reminder set for " + reminder.getRemindAt());
    }

    private synchronized void addHistory(String entry) {
        history.add(new Date() + ": " + entry);
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Date getDueDate() { return dueDate; }
    public TaskPriority getPriority() { return priority; }
    public TaskStatus getStatus() { return status; }
    public User getAssignee() { return assignee; }
    public List<Comment> getComments() { return List.copyOf(comments); }
    public List<String> getHistory() { return List.copyOf(history); }
    public List<Reminder> getReminders() { return List.copyOf(reminders); }

    @Override
    public String toString() {
        return getTitle() + " [" + getStatus() + "] - " + getAssignee().name();
    }
}