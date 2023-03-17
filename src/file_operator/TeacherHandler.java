package file_operator;

import character_attribute.Teacher;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A data handler for Teacher objects. Implements DataHandler interface.
 */
public class TeacherHandler implements DataHandler<Teacher> {

    /**
     * Reads a list of Teacher objects from a JSON root node.
     *
     * @param rootNode the root node of the JSON data
     * @return a list of Teacher objects
     */
    @Override
    public List<Teacher> readData(JsonNode rootNode) {
        List<Teacher> teachers = new ArrayList<>();

        // Iterate over each training plan node in the JSON data
        JsonNode trainingPlansNode = rootNode.get("training_plan");
        for (JsonNode planNode : trainingPlansNode) {
            // Create a new Teacher object and set its name
            Teacher teacher = new Teacher();
            teacher.setName(planNode.get("teacher_name").asText());

            // Create a list of courses taught by the teacher and add it to the Teacher object
            List<String> teacherCourses = new ArrayList<>();
            teacherCourses.add(planNode.get("course").asText());
            teacher.setCourse(teacherCourses);

            // Add the Teacher object to the list of teachers
            teachers.add(teacher);
        }

        return teachers;
    }

    /**
     * Writes a list of Teacher objects to a JSON array node.
     *
     * @param data the list of Teacher objects to write
     * @return a JSON array node containing the serialized Teacher objects
     */
    @Override
    public ArrayNode writeData(List<Teacher> data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
