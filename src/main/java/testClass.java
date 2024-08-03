import  imageX.image.imagefilters.imageFiltering;
import   java.io.*;
import  Gui.mainWindow.*;
import   javax.imageio.ImageIO;
import   imageX.Console.ImageXConsole;
import app.data.CurrentValues;


public class testClass {

    public static void main(String[] args) throws IOException {
        ImageXConsole imgConsole = new ImageXConsole();
        imgConsole.consoleLogStart();
        CurrentValues cv_1 = new CurrentValues();
        MainWindow mainWindow = new MainWindow();
        //new ImgEditor();
        File imageFile = new File("testImages/Man_1.jpg");
        imgConsole.consoleLog("Original Image path : "+ imageFile.getPath());
        imgConsole.consoleLog("Is Image Found : "+ imageFile.exists());
        imageFiltering image_1 = new imageFiltering(imageFile);
        //cv_1.setCurrentSelectedImageBufferedData(image_1.bufferdImage);
        //image_1.displayImage(cv_1.getCurrentSelectedImageBufferedData());

         //image_1.displayImage(image_1.bufferdImage);
        //image_1.displayImage(image_1.resizeImage(image_1.bufferdImage,250,320));
        //image_1.displayImage(image_1.cropImage(image_1.bufferdImage,100,250,100,100));
        //image_1.displayImage(image_1.adjustBrightness(image_1.bufferdImage,10.13));
          //image_1.displayImage(image_1.dynamicBlur(image_1.bufferdImage,5));//image_1.displayImage(image_1.toGrayScale(image_1.bufferdImage));
        //image_1.displayImage(image_1.toGrayScale2(image_1.bufferdImage));
        // image_1.displayImage(image_1.pixelate(image_1.bufferdImage));
        //image_1.displayImage(image_1.pixelate_2(image_1.bufferdImage,5));
        //image_1.saveBufferedImageAsJPG(image_1.pixelate_2(image_1.bufferdImage,5),"testImages/Pixel_5.jpg");
         //imgConsole.consoleLogEnd();

    }
}
