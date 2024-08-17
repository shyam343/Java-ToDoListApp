import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    boolean isCompleted;

    Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        return name + (isCompleted ? " [Completed]" : " [Pending]");
    }
}

public class ToDoListApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    editTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        tasks.add(new Task(name));
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void editTask() {
        viewTasks();
        System.out.print("Enter the task number to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        System.out.print("Enter new task name: ");
        String newName = scanner.nextLine();
        tasks.get(index).name = newName;
        System.out.println("Task updated.");
    }

    private static void deleteTask() {
        viewTasks();
        System.out.print("Enter the task number to delete: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.remove(index);
        System.out.println("Task deleted.");
    }
}
