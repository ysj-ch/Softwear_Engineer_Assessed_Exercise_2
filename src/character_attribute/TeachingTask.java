package character_attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TeachingTask {

    private Course course;
    @JsonProperty("task_requirement")
    private String taskRequirement;

    public TeachingTask() {}

    @JsonCreator
    public TeachingTask(@JsonProperty("course") Course course, @JsonProperty("task_requirement") String taskRequirement) {
        this.course = course;
        this.taskRequirement = taskRequirement;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTaskRequirement() {
        return taskRequirement;
    }

    public void setTaskRequirement(String TaskRequirement) {
        this.taskRequirement = TaskRequirement;
    }

    @Override
    public String toString() {
        return "Course Name: " + course.getCourseName() + ", Task Requirement: " + taskRequirement;
    }

}