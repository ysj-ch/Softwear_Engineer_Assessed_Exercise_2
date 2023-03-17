package file_operator;

import character_attribute.TeachingTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class TeachingTaskHandler implements DataHandler<TeachingTask> {

    /**
     * Read teaching task data from a JSON node.
     *
     * @param rootNode the root JSON node to read from
     * @return a list of teaching tasks
     */
    @Override
    public List<TeachingTask> readData(JsonNode rootNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<TeachingTask> teachingTasks = new ArrayList<>();
        try {
            // Get the "teaching_tasks" node from the root JSON node
            JsonNode teachingTasksNode = rootNode.get("teaching_tasks");
            // Deserialize the teaching tasks from the JSON node using Jackson
            teachingTasks = objectMapper.readValue(teachingTasksNode.toString(), new TypeReference<List<TeachingTask>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return teachingTasks;
    }

    /**
     * Write teaching task data to a JSON array node.
     *
     * @param data the list of teaching tasks to write
     * @return a JSON array node containing the teaching tasks
     */
    @Override
    public ArrayNode writeData(List<TeachingTask> data) {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ArrayNode teachingTasksNode = factory.arrayNode();

        for (TeachingTask task : data) {
            ObjectNode taskNode = factory.objectNode();
            // Add the course name and task requirement to the task node
            taskNode.put("course", task.getCourse().getCourseName());
            taskNode.put("task_requirement", task.getTaskRequirement());
            teachingTasksNode.add(taskNode);
        }

        return teachingTasksNode;
    }
}







