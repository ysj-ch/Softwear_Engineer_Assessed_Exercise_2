package factory;

import file_operator.Data;

public interface IFactoryTeachingTask {
    void addTeachingTask(String courseName, String taskRequirement, Data data);
    void getAllTeachingTask(Data data);
}
