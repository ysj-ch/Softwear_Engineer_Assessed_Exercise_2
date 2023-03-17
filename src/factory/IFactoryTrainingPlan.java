package factory;

import character_attribute.Course;
import character_attribute.Teacher;
import file_operator.Data;

public interface IFactoryTrainingPlan {

    void addTrainingPlan(String name, String description, Data data);

    void getAllTrainingPlans(Data data);
}
