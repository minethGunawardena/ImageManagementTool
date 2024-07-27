package app.data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData {
    JSONObject jsonObject = null;
    JSONParser parser = new JSONParser();
    String jsonPath;
    public SaveData(String jsonFilePath){
        jsonPath = jsonFilePath;

        try (FileReader reader = new FileReader(jsonFilePath)) {
            Object obj = parser.parse(reader);
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void saveStringData(String key,String value){
        jsonObject.put(key, value);
        try (FileWriter file = new FileWriter(jsonPath)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void savelongData(String key,Long value){
        jsonObject.put(key, value);
        try (FileWriter file = new FileWriter(jsonPath)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
