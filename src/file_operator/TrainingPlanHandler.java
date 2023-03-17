package file_operator;

import character_attribute.TrainingPlan;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class TrainingPlanHandler implements DataHandler<TrainingPlan> {
    @Override
    public List<TrainingPlan> readData(JsonNode rootNode) {
        // Create an ObjectMapper instance to convert JSON data to Java objects
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a list to store the training plans
        List<TrainingPlan> trainingPlans = new ArrayList<>();

        try {
            // Get the JSON node for the training plans from the root node
            JsonNode trainingPlanNode = rootNode.get("training_plan");

            // Use the ObjectMapper to convert the JSON data to a list of TrainingPlan objects
            trainingPlans = objectMapper.readValue(trainingPlanNode.toString(), new TypeReference<List<TrainingPlan>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Return the list of training plans
        return trainingPlans;
    }

    public ArrayNode writeData(List<TrainingPlan> data) {
        // Create a JsonNodeFactory instance to create JSON objects and arrays
        JsonNodeFactory factory = JsonNodeFactory.instance;

        // Create an array node to store the training plans
        ArrayNode trainingPlanNode = factory.arrayNode();

        // Loop through the training plans and add each one to the array node
        for (TrainingPlan plan : data) {
            // Create a JSON object to represent the training plan
            ObjectNode planNode = factory.objectNode();
            planNode.put("teacher_name", plan.getTeacherName());
            planNode.put("course", plan.getCourseName());

            // Add the JSON object to the array node
            trainingPlanNode.add(planNode);
        }

        // Return the array node
        return trainingPlanNode;
    }
}