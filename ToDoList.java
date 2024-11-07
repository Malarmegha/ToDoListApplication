import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private static ArrayList<String> todoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSimple Todo List Application");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    deleteTask();
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter the task you want to add: ");
        String task = scanner.nextLine();
        todoList.add(task);
        System.out.println("Task \"" + task + "\" added to the todo list!");
    }

    private static void viewTasks() {
        if (todoList.isEmpty()) {
            System.out.println("Your todo list is empty.");
            return;
        }
        System.out.println("\nYour Todo List:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
    }

    private static void deleteTask() {
        viewTasks();
        if (todoList.isEmpty()) {
            return;
        }
        try {
            System.out.print("Enter the task number to delete: ");
            int taskNumber = Integer.parseInt(scanner.nextLine()) - 1;
            if (taskNumber >= 0 && taskNumber < todoList.size()) {
                String deletedTask = todoList.remove(taskNumber);
                System.out.println("Task \"" + deletedTask + "\" deleted successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}
