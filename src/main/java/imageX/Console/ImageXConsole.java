package imageX.Console;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import app.data.AppData;
import app.data.*;


public class ImageXConsole {

    LoadData data_1 = new LoadData("Settings/app/app_Settings.json");
    SaveData data_2 = new SaveData("Settings/app/app_Settings.json");
    Long Attempt  = data_1.getLongValues("appRunAttempt");
    LocalDate date = LocalDate.now();
    LocalTime now = LocalTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String appVersion = new AppData().getApplicationVersion();
    String filePath = "Log/Console_log.txt";

    public void consoleLog(String massage){

        String fullMassage = "App version:<<"+ appVersion+">>"+"||"+date+"||"+now.format(timeFormatter)+"|| System.Log("+massage+");";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(fullMassage+"\n");
            System.out.println(massage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void consoleLogStart(){

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<App-Start Attempt "+Attempt+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+date+"||"+now.format(timeFormatter)+" \n");
            writer.write("App-Version:<<"+appVersion+">>"+"\n");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<App-Start Attempt "+Attempt+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+date+"||"+now.format(timeFormatter));
            System.out.println("App-Version:<<"+appVersion+">>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void consoleLogEnd(){
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<App-end Attempt "+Attempt+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+date+"||"+now.format(timeFormatter)+"\n \n");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<App-end Attempt "+Attempt+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+date+"||"+now.format(timeFormatter)+"\n \n \n\n");
            Attempt ++;
            data_2.savelongData("appRunAttempt",Attempt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
