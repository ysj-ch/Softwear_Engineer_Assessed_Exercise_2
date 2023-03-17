package manager;

import factory.IFactoryTeachingTask;
import file_operator.Data;

import java.util.Scanner;

/**
 * A manager for handling teaching tasks.
 */
public class TeachingTaskManager implements Manager {
    private IFactoryTeachingTask teachingTaskFactory;

    public TeachingTaskManager(IFactoryTeachingTask teachingTaskFactory) {
        this.teachingTaskFactory = teachingTaskFactory;
    }

    @Override
    public void manage(Scanner scanner, Data data, String writeFilePath) {
        int option;
        while (true) {
            System.out.println("\nTeaching Task Manager");
            System.out.println("1. Add A Teaching Requirement");
            System.out.println("2. View all teaching tasks");
            System.out.println("0. Go back");
            System.out.print("Enter the corresponding number: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Prompt the user to add a new teaching requirement
                    int trInput = addTeachingRequirement(scanner, data, writeFilePath);
                    if(trInput==2){break;}
                case 2:
                    // Show all teaching tasks
                    System.out.println("All Teaching Tasks:");
                    teachingTaskFactory.getAllTeachingTask(data);
                    break;
                case 0:
                    // Exit the manager
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public int addTeachingRequirement(Scanner scanner, Data data, String writeFilePath){

        // Prompt the user to enter the course name and specific requirements for the new teaching task
        System.out.print("\n[Teaching Requirement]Please enter the Course Name: ");
        String name = scanner.nextLine();
        System.out.print("[Teaching Requirement]Please enter specific requirements: ");
        String description = scanner.nextLine();

        // Add the new teaching task to the data and write it to the file
        teachingTaskFactory.addTeachingTask(name, description, data);
        data.writeToJsonFile(writeFilePath);
        System.out.println("\nTeaching task added successfully.");

        // Prompt the user to read the teaching requirement
        System.out.println("\nDo you want to read the teaching Requirement?");
        System.out.println("1:Yes  2:No");

        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
}