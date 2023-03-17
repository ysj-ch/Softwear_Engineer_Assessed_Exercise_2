package manager;

import file_operator.Data;

import java.util.Scanner;

/**
 * The Manager interface defines a common behavior for all managers in the Training Management System.
 * It provides a method to manage the system based on user input.
 */
public interface Manager {
    /**
     * Manages the Training Management System based on user input.
     *
     * @param scanner      The scanner to read user input from.
     * @param data         The data object that holds all the information about the system.
     * @param writeFilePath The path to the file where the updated data should be written.
     */
    void manage(Scanner scanner, Data data, String writeFilePath);
}
