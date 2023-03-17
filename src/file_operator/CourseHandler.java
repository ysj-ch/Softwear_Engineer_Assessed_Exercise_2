package file_operator;

import character_attribute.Course;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;

public class CourseHandler implements DataHandler<Course> {
    @Override
    public List<Course> readData(JsonNode rootNode) {
        // Create a new ArrayList to store the courses
        List<Course> courses = new ArrayList<>();

        // Get the "teaching_tasks" node from the JSON data
        JsonNode teachingTasksNode = rootNode.get("teaching_tasks");

        // Loop through each teaching task node and extract the course name
        for (JsonNode taskNode : teachingTasksNode) {
            Course course = new Course();
            course.setCourseName(taskNode.get("course").asText());
            courses.add(course);
        }

        // Return the list of courses
        return courses;
    }

    @Override
    public ArrayNode writeData(List<Course> data) {
        // If you need to write course data, implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
