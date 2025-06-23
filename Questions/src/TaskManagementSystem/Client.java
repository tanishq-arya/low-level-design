package TaskManagementSystem;

import java.util.Date;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        TaskManager manager = TaskManager.getInstance();

        // Create users and set current
        User alice = new User("u1", "Alice", "alice@example.com");
        User bob   = new User("u2", "Bob",   "bob@example.com");
        manager.setCurrentUser(alice);

        // Create tasks
        Task task1 = manager.createTask("Design API", "Define endpoints", new Date(), TaskPriority.HIGH, alice);
        Task task2 = manager.createTask("Write Tests", "Unit tests", new Date(), TaskPriority.MEDIUM, alice);

        // Assign task2 to Bob
        manager.assignTask(task2.getId(), bob);

        // Add reminder for task1
        manager.addReminder(task1.getId(), new Date(System.currentTimeMillis() + 3600_000));

        // Alice marks task-1 in progress
        manager.updateTaskStatus(task1.getId(), TaskStatus.IN_PROGRESS);

        // Bob comments on task-2
        manager.setCurrentUser(bob);
        manager.addComment(task2.getId(), "I'll start tomorrow", bob);

        // List all tasks
        List<Task> all = manager.listTasks();
        System.out.println("All Tasks:");
        all.forEach(System.out::println);

        // Show history of task-1
        System.out.println("\nHistory of t1:");
        task1.getHistory().forEach(System.out::println);

        // Delete task2 by Bob
        manager.deleteTask(task2.getId());
        System.out.println("\nAfter deletion, all tasks:");
        manager.listTasks().forEach(System.out::println);
    }
}