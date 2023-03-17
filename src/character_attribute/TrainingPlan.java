package character_attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class TrainingPlan {
    @JsonProperty("teacher_name")
    private String teacherName;

    @JsonProperty("course")
    private String courseName;

    public TrainingPlan(){}
    public TrainingPlan(@JsonProperty("teacher_name") String teacherName, @JsonProperty("course") String courseName) {
        this.teacherName = teacherName;
        this.courseName = courseName;
    }


    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String toString() {
        return "Teacher Name :" + this.teacherName + ",CourseName : " + this.courseName;
    }

}

