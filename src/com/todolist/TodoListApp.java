package com.todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private static ArrayList<String> todoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 4) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add a task");
        System.out.println("2. View tasks");
        System.out.println("3. Remove a task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine();
        todoList.add(task);
        System.out.println("Task added!");
    }

    private static void viewTasks() {
        if (todoList.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("\n--- To-Do List ---");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    private static void removeTask() {
        if (todoList.isEmpty()) {
            System.out.println("No tasks to remove.");
        } else {
            System.out.print("Enter the task number to remove: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (taskNumber > 0 && taskNumber <= todoList.size()) {
                todoList.remove(taskNumber - 1);
                System.out.println("Task removed!");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
