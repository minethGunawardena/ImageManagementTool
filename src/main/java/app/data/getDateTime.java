package app.data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class getDateTime {
    LocalDate today;
    LocalTime now;

    public getDateTime(){
        today = LocalDate.now();
        now = LocalTime.now();
    }
    public String getCurrentDate(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(dateFormatter);
        return  formattedDate;
    }
    public String getCurrentTime(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(timeFormatter);
        return  formattedTime;
    }
}
