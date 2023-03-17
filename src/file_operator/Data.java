package file_operator;

import character_attribute.Course;
import character_attribute.Teacher;
import character_attribute.TeachingTask;
import character_attribute.TrainingPlan;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Data {
    // These are the lists of different types of data that will be stored
    // in the system.
    private List<Course> courses;
    private List<Teacher> teachers;
    private List<TeachingTask> teachingTasks;
    private List<TrainingPlan> trainingPlans;

    // These are the handlers that will be used to read and write data to
    // and from the JSON file.
    private DataHandler<Course> courseHandler;
    private DataHandler<Teacher> teacherHandler;
    private DataHandler<TeachingTask> teachingTaskHandler;
    private DataHandler<TrainingPlan> trainingPlanHandler;

    // Constructor for the Data class. Initializes the handlers for each
    // type of data.
    public Data() {
        courseHandler = new CourseHandler();
        teacherHandler = new TeacherHandler();
        teachingTaskHandler = new TeachingTaskHandler();
        trainingPlanHandler = new TrainingPlanHandler();
    }

    // Reads the data from a JSON file and initializes the corresponding lists
    // with the data.
    public void readJsonFile(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(path);
            JsonNode rootNode = objectMapper.readTree(file);
            teachingTasks = teachingTaskHandler.readData(rootNode);
            trainingPlans = trainingPlanHandler.readData(rootNode);
            courses = courseHandler.readData(rootNode);
            teachers = teacherHandler.readData(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Writes the data in the lists to a JSON file.
    public void writeToJsonFile(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        JsonNodeFactory factory = JsonNodeFactory.instance;

        ObjectNode rootNode = factory.objectNode();
        rootNode.set("teaching_tasks", teachingTaskHandler.writeData(teachingTasks));
        rootNode.set("training_plan", trainingPlanHandler.writeData(trainingPlans));

        try {
            File file = new File(path);
            objectMapper.writeValue(file, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters and setters for each of the lists.
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<TeachingTask> getTeachingTasks() {
        return teachingTasks;
    }

    public void setTeachingTasks(List<TeachingTask> teachingTasks) {
        this.teachingTasks = teachingTasks;
    }

    public List<TrainingPlan> getTrainingPlans() {
        return trainingPlans;
    }

    public void setTrainingPlans(List<TrainingPlan> trainingPlans) {
        this.trainingPlans = trainingPlans;
    }
}
