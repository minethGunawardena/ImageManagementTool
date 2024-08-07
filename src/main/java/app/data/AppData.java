package app.data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import  app.data.LoadData;

public class AppData {//////////Stores And Reads the application data such as app version

    private String applicationVersion;
    private LoadData data_1;
    public AppData()throws fileNotfoundException, ParseException, IOException{
        data_1 = new LoadData(jsonfilePath:"Settings/app/app_Settings.json");
        applicationVersion =data_1.getStringValue("appVersion");
    }
    public String getApplicationVersion(){
        return  applicationVersion;
    }
}
