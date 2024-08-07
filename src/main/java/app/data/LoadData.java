package app.data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Class to load data from a JSON file
public class LoadData {
    JSONParser parser = new JSONParser();
    JSONObject jsonObject;
    
    // Constructor that takes the file path of the JSON file
    public LoadData(String jsonFilePath){
        try(FileReader reader = new FileReader(jsonFilePath)){
            Object obj = parser.parse(reader);
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public String getStringValue(String key){
        String returnvalue;
        returnvalue = (String) jsonObject.get(key);

        return  returnvalue;

    }
      // Method to retrieve a Long value associated with the specified key
    public Long getLongValues(String key){
         Long returnvalue = (long) jsonObject.get(key);
        return returnvalue;

    }

}
