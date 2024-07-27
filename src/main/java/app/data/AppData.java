package app.data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import  app.data.LoadData;

public class AppData {//////////Stores And Reads the application data such as app version

    String applicationVersion;
    LoadData data_1 = new LoadData("Settings/app/app_Settings.json");
    public AppData(){
        applicationVersion =data_1.getStringValue("appVersion");
    }
    public String getApplicationVersion(){
        return  applicationVersion;
    }
}
