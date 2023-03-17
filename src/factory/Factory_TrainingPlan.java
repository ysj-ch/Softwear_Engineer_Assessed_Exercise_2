package factory;

import character_attribute.TrainingPlan;
import file_operator.Data;

import java.util.List;

public class Factory_TrainingPlan implements IFactoryTrainingPlan {

    // Default constructor
    public Factory_TrainingPlan() {}

    // Method to add a new training plan to the system
    @Override
    public void addTrainingPlan(String name, String description, Data data) {
        // Get the list of training plans from the Data object
        List<TrainingPlan> trainingPlans = data.getTrainingPlans();

        // Create a new TrainingPlan object with the given name and description
        TrainingPlan trainingPlan = new TrainingPlan(name, description);

        // Add the new training plan to the list of training plans
        trainingPlans.add(trainingPlan);

        // Update the training plans list in the Data object
        data.setTrainingPlans(trainingPlans);
    }

    // Method to display all training plans in the system
    @Override
    public void getAllTrainingPlans(Data data) {
        // Get the list of training plans from the Data object
        List<TrainingPlan> trainingPlans = data.getTrainingPlans();

        // Loop through each training plan and print its teacher name and course name
        for (TrainingPlan trainingPlan : trainingPlans) {
            System.out.println("Teacher Name: " + trainingPlan.getTeacherName() + ", Course Name:" + trainingPlan.getCourseName());
        }
    }
}
