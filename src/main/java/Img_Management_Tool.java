import Gui.mainWindow.MainWindow;
import RecyleBin.ImageCleanupQueue;
import app.data.CurrentValues;
import imageX.Console.ImageXConsole;

import java.io.File;

public class Img_Management_Tool {
    public static void main(String[] args) {
        ImageXConsole imgConsole = new ImageXConsole();
        imgConsole.consoleLogStart();

        ImageCleanupQueue imageCleanupQueue = new ImageCleanupQueue();
        File folder = new File("Temp/Images");
        imageCleanupQueue.addFilesToQueue(folder.listFiles());
        imageCleanupQueue.startCleanup();

        CurrentValues cv_1 = new CurrentValues();
        MainWindow mainWindow = new MainWindow();
    }
}
