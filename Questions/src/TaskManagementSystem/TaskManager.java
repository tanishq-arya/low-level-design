package TaskManagementSystem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

// Singleton Manager
public class TaskManager {
    private static TaskManager instance; // single instance

    // resources
    private final Map<String, Task> tasks;
    private User currentUser;

    private TaskManager() {
        tasks = new ConcurrentHashMap<>(); // Why ?
    }

    // Thread-safe instance getter
    public static synchronized TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Task createTask(String title, String desc, Date dueDate,
                           TaskPriority priority, User assignee) {
        Task task = new Task(title, desc, dueDate, priority, assignee, currentUser);
        tasks.put(task.getId(), task);
        return task;
    }

    public void updateTaskStatus(String taskId, TaskStatus s) {
        getTask(taskId).updateStatus(s);
    }

    public void updateTaskPriority(String taskId, TaskPriority p) {
        getTask(taskId).updatePriority(p);
    }

    public void assignTask(String taskId, User u) {
        getTask(taskId).assignUser(u);
    }

    public void addComment(String taskId, String text, User author) {
        getTask(taskId).addComment(new Comment(text, author));
    }

    public void addReminder(String taskId, Date remindAt) {
        getTask(taskId).addReminder(new Reminder(remindAt));
    }

    public List<Task> listTasks() {
        return new ArrayList<>(tasks.values());
    }

    public List<Task> listByStatus(TaskStatus s) {
        return tasks.values().stream()
                .filter(t -> t.getStatus() == s)
                .collect(Collectors.toList());
    }

    public List<Task> listByAssignee(User u) {
        return tasks.values().stream()
                .filter(t -> u.equals(t.getAssignee()))
                .collect(Collectors.toList());
    }

    public List<Task> searchTasks(String keyword) {
        return tasks.values().stream()
                .filter(t -> t.getTitle().contains(keyword)
                        || t.getDescription().contains(keyword))
                .collect(Collectors.toList());
    }

    public void deleteTask(String taskId) {
        Task task = getTask(taskId);
        // only creator (in history first entry) or assignee can delete
        // for simplicity, check currentUser == assignee
        if (!Objects.equals(currentUser, task.getAssignee())) {
            throw new SecurityException("Not authorized to delete task");
        }
        tasks.remove(taskId);
    }

    private Task getTask(String taskId) {
        Task task = tasks.get(taskId);
        if (task == null) throw new NoSuchElementException("Task not found: " + taskId);
        return task;
    }

}