package file_operator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.List;

/**
 * This interface defines methods for reading and writing data to a JSON file using the Jackson library.
 * The type parameter T specifies the type of data that the implementing class will handle.
 */
public interface DataHandler<T> {

    /**
     * Reads data from the JSON file and returns a list of objects of type T.
     *
     * @param rootNode the root node of the JSON tree
     * @return a list of objects of type T
     */
    List<T> readData(JsonNode rootNode);

    /**
     * Writes the given list of data to a JSON array node.
     *
     * @param data the list of data to be written to JSON
     * @return an array node containing the data in JSON format
     */
    ArrayNode writeData(List<T> data);
}

