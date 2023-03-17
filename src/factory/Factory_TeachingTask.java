package factory;

import character_attribute.Course;
import character_attribute.TeachingTask;
import file_operator.Data;

import java.util.List;

public class Factory_TeachingTask implements IFactoryTeachingTask {

    // Constructor for the Factory_TeachingTask class
    public Factory_TeachingTask(){}

    // Method for adding a new teaching task to the data object
    @Override
    public void addTeachingTask(String courseName, String taskRequirement, Data data) {
        // Get the list of teaching tasks from the data object
        List<TeachingTask> teachingTasks = data.getTeachingTasks();

        // Create a new course object with the given course name
        Course course = new Course(courseName);

        // Create a new teaching task object with the given course and task requirements
        TeachingTask task = new TeachingTask(course, taskRequirement);

        // Add the new teaching task to the list of teaching tasks in the data object
        teachingTasks.add(task);

        // Update the teaching tasks list in the data object
        data.setTeachingTasks(teachingTasks);
    }

    // Method for printing all teaching tasks in the data object to the console
    @Override
    public void getAllTeachingTask(Data data) {
        // Get the list of teaching tasks from the data object
        List<TeachingTask> tasks = data.getTeachingTasks();

        // Loop through each teaching task and print its course name and task requirement to the console
        for (TeachingTask task : tasks) {
            System.out.print("Course Name: " + task.getCourse().getCourseName() + ", Task Requirement: " + task.getTaskRequirement());

            // If the teaching task is not assigned to a course, print a message indicating that
            if (task.getCourse() == null) {
                System.out.println(" (No course assigned)");
            } else {
                System.out.println();
            }
        }
    }
}








