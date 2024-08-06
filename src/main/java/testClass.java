import  imageX.image.imagefilters.imageFiltering;
import   java.io.*;
import   javax.imageio.ImageIO;
import   imageX.Console.ImageXConsole;

public class testClass {

    public static void main(String[] args) throws IOException {
        ImageXConsole imgConsole = new ImageXConsole();
        imgConsole.consoleLogStart();
        File imageFile = new File("testImages/Man_2.jpg");
        imgConsole.consoleLog("Original Image path : "+ imageFile.getPath());
        imgConsole.consoleLog("Is Image Found : "+ imageFile.exists());
        imageFiltering image_1 = new imageFiltering(imageFile);
        image_1.displayImage(image_1.bufferdImage);
        //image_1.displayImage(image_1.resizeImage(image_1.bufferdImage,250,320));
        //image_1.displayImage(image_1.cropImage(image_1.bufferdImage,100,250,600,320));
        //image_1.displayImage(image_1.adjustBrightness(image_1.bufferdImage,1.13));
        image_1.displayImage(image_1.dynamicBlur(image_1.bufferdImage,2));//image_1.displayImage(image_1.toGrayScale(image_1.bufferdImage));
        //image_1.displayImage(image_1.toGrayScale2(image_1.bufferdImage));
        // image_1.displayImage(image_1.pixelate(image_1.bufferdImage));
        //image_1.displayImage(image_1.pixelate_2(image_1.bufferdImage,8));
        image_1.saveBufferedImageAsJPG(image_1.dynamicBlur(image_1.bufferdImage,2),"testImages/blur_2.jpg");
        imgConsole.consoleLogEnd();


        //Bug Fixed
    }
}
