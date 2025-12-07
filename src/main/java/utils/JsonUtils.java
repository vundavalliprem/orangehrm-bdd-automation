package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Simple utility class for reading JSON test data
 */
public class JsonUtils {

    /**
     * Reads a specific object from JSON file by key
     * @param filePath Path to JSON file
     * @param key Key to retrieve from JSON
     * @return JSONObject containing the data
     */
    public static JSONObject readJSON(String filePath, String key) {
        try (FileReader reader = new FileReader(filePath)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return (JSONObject) jsonObject.get(key);
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath + ", key: " + key, e);
        }
    }
}
