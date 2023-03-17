import factory.Factory_TeachingTask;
import factory.Factory_TrainingPlan;
import factory.IFactoryTeachingTask;
import factory.IFactoryTrainingPlan;
import file_operator.Data;
import manager.Manager;
import manager.TeachingTaskManager;
import manager.TrainingPlanManager;

import java.util.Scanner;

public class Main {
    // Create a new instance of the Data class
    public static Data data = new Data();

    // Create a new instance of the Factory_TrainingPlan class
    public static IFactoryTrainingPlan trainingPlanFactory = new Factory_TrainingPlan();

    // Create a new instance of the Factory_TeachingTask class
    public static IFactoryTeachingTask teachingTaskFactory = new Factory_TeachingTask();

    public static void main(String[] args) {
        // Define the file path for reading and writing data
        String filePath = "data/data.json";
        String writeFilePath = "data/data1.json";

        // Read the data from the file
        data.readJsonFile(filePath);

        // Create a new scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Define a variable to store the user's role
        int role;

        // Create instances of the TrainingPlanManager and TeachingTaskManager classes
        Manager trainingPlanManager = new TrainingPlanManager(trainingPlanFactory);
        Manager teachingTaskManager = new TeachingTaskManager(teachingTaskFactory);

        // Print a welcome message to the user
        System.out.println("Welcome to the Training Management System!");

        // Run an infinite loop to allow the user to interact with the system
        while (true) {
            // Print the available roles to the user
            System.out.println("\nSelect your role:");
            System.out.println("1. Class director");
            System.out.println("2. Administrator");
            System.out.println("0. Exit");

            // Read the user's choice
            System.out.print("Enter the corresponding number: ");
            role = scanner.nextInt();
            scanner.nextLine();

            // Depending on the user's role, call the corresponding manager object's manage method
            switch (role) {
                case 1:
                    teachingTaskManager.manage(scanner, data,writeFilePath);
                    break;
                case 2:
                    trainingPlanManager.manage(scanner, data, writeFilePath);
                    break;
                case 0:
                    // Exit the program if the user selects 0
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    // Print an error message if the user enters an invalid option
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}






