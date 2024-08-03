package app.data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import imageX.stucture.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import app.data.*;

import  app.data.LoadData;

import javax.imageio.ImageIO;

public class CurrentValues {
    Image imagelinkList = new Image();
    SaveData data_s = new SaveData("Settings/CurrentVariables/currentValues.json");
    LoadData data_L = new LoadData("Settings/CurrentVariables/currentValues.json");
    String currentSelectedImageName;
    String currentImagePath;
    String currentFileSavePath;
    BufferedImage currentSelectedImageBufferedData;
    public CurrentValues(){

        currentSelectedImageName = null;
        currentSelectedImageBufferedData = null;
        currentFileSavePath = null;
        currentImagePath = null;
    }

    public void setCurrentImageName(String ImageName){
        currentSelectedImageName = ImageName;
        data_s.saveStringData("currentSelectedImageName",currentSelectedImageName);
    }
    public String getCurrentSelectedImageName(){
        currentSelectedImageName = data_L.getStringValue("currentSelectedImageName");
        return currentSelectedImageName;
    }

    public void setCurrentImagePath(String ImagePath){
        currentImagePath = ImagePath;
        data_s.saveStringData("currentImagePath",currentImagePath);
    }
    public String getCurrentImagePath(){
        currentImagePath = data_L.getStringValue("currentImagePath");
        return currentImagePath;
    }

    public void setCurrentSelectedImageBufferedData(BufferedImage ImageData){
        currentSelectedImageBufferedData = ImageData;
        String base64String = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            ImageIO.write(ImageData, "jpg", baos);
            byte[] imageBytes = baos.toByteArray();


            base64String = Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        data_s.saveStringData("BufferedImageData",base64String);
    }
    public BufferedImage getCurrentSelectedImageBufferedData(){
        BufferedImage image = null;
        try {
            byte[] imageBytes = Base64.getDecoder().decode(data_L.getStringValue("BufferedImageData"));
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes)) {
                image = ImageIO.read(bais);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentSelectedImageBufferedData = image;
        return currentSelectedImageBufferedData;
    }

    public void setCurrentFileSavePath(String finalSavePath){
         currentFileSavePath = finalSavePath;
        data_s.saveStringData("currentFileSavePath",currentFileSavePath);
    }
    public String getCurrentFileSavePath(){
        currentFileSavePath = data_L.getStringValue("currentFileSavePath");
        return currentFileSavePath;
    }
}
