package manager;

import factory.IFactoryTrainingPlan;
import file_operator.Data;

import java.util.Scanner;

/**
 * A manager for handling Teaching Plans.
 */
public class TrainingPlanManager implements Manager {
    // Instance variable for the TrainingPlanFactory
    private IFactoryTrainingPlan trainingPlanFactory;

    // Constructor that takes a TrainingPlanFactory as a parameter
    public TrainingPlanManager(IFactoryTrainingPlan trainingPlanFactory) {
        this.trainingPlanFactory = trainingPlanFactory;
    }

    @Override
    public void manage(Scanner scanner, Data data, String writeFilePath) {
        // Define a variable to store the user's choice
        int option;

        // Run an infinite loop to allow the user to interact with the system
        while (true) {
            // Print the available options to the user
            System.out.println("\nTraining Plan Manager");
            System.out.println("1. Add a training plan");
            System.out.println("2. View all training plans");
            System.out.println("0. Go back");
            System.out.print("Enter the corresponding number: ");

            // Read the user's choice
            option = scanner.nextInt();
            scanner.nextLine();

            // Depending on the user's choice, call the corresponding method
            switch (option) {
                case 1:
                    // Call the addTrainingPlan method and store the user's input
                    int trInput = addTrainingPlan(scanner, data, writeFilePath);

                    // If the user chose to not read the training plan, break out of the switch statement
                    if(trInput==2){break;}
                case 2:
                    // Call the getAllTrainingPlans method to display all the training plans
                    System.out.println("All Training Plans:");
                    trainingPlanFactory.getAllTrainingPlans(data);
                    break;
                case 0:
                    // Exit the method if the user chooses to go back
                    return;
                default:
                    // Print an error message if the user enters an invalid option
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to add a new training plan to the system
    public int addTrainingPlan(Scanner scanner, Data data, String writeFilePath){
        // Prompt the user to enter the teacher name and training plan description
        System.out.print("\nEnter the teacher name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the training plan description: ");
        String description = scanner.nextLine();

        // Call the addTrainingPlan method of the TrainingPlanFactory to create a new training plan
        trainingPlanFactory.addTrainingPlan(name, description, data);

        // Write the updated data to the JSON file
        data.writeToJsonFile(writeFilePath);

        // Print a success message to the user
        System.out.println("\nTraining plan added successfully.");

        // Prompt the user if they want to read the training plan that was just added
        System.out.println("\nDo you want to read the Training Plan?");
        System.out.println("1:Yes  2:No");

        // Read the user's choice and return it to the calling method
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
}
