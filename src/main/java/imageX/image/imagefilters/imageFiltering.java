package imageX.image.imagefilters;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import   java.awt.*;
import   java.awt.image.*;
import   java.io.*;
import   javax.imageio.ImageIO;
import   javax.swing.*;
import java.awt.geom.AffineTransform;
import   imageX.Console.ImageXConsole;

public class imageFiltering {
    File imageFile;
    public BufferedImage bufferdImage;
    ImageXConsole imgConsole = new ImageXConsole();

    public imageFiltering(File image_File){
        imageFile = image_File ;
        try{
            bufferdImage= ImageIO.read(imageFile);

        }catch(IOException e){

            imgConsole.consoleLog("Error Class Creation failed.imageFiltering :" +e.getMessage());

        }
    }
    public imageFiltering(){

    }

    public void displayImage(BufferedImage image){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            imgConsole.consoleLog("Error Cannot Display image imagefilrering:"+e.getMessage());
        }
        if(image != null){
            imgConsole.consoleLog("Loading Image");
            imgConsole.consoleLog("Displaying Image");
            JFrame frame = new JFrame();
            JLabel imageViewer = new JLabel();
            frame.setSize(image.getWidth(),image.getHeight());
            imageViewer.setIcon(new ImageIcon(image));
            frame.getContentPane().add(imageViewer,BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);

        }else{
            imgConsole.consoleLog("Error failed to load or Display image.imageFiltering : NO Image File Found");
        }

    }

    public BufferedImage toGrayScale(@NotNull BufferedImage image){
        imgConsole.consoleLog("Converting Image To Grayscale");
        BufferedImage grayImage = new BufferedImage(
                image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = grayImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return grayImage;
    }

    public BufferedImage toGrayScale2(@NotNull BufferedImage image){
        imgConsole.consoleLog("Converting image to grayScale(Method_2)");
        BufferedImage grayImage = new BufferedImage(
                image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        int rgb=0, r=0, g=0, b=0;
        for (int y=0; y<image.getHeight(); y++) {
            for (int x=0; x<image.getWidth(); x++) {
                rgb = (int)(image.getRGB(x, y));
                r = ((rgb >> 16) & 0xFF);
                g = ((rgb >> 8) & 0xFF);
                b = (rgb & 0xFF);
                rgb = (int)((r+g+b)/3);
                //rgb = (int)(0.299 * r + 0.587 * g + 0.114 * b);
                rgb = (255<<24) | (rgb<<16) | (rgb<<8) | rgb;
                grayImage.setRGB(x,y,rgb);
            }
        }
        return grayImage;
    }

    public BufferedImage pixelate (@NotNull BufferedImage image) {
        imgConsole.consoleLog(" Ajusting Grayscale image Pixalation");
        BufferedImage pixImg = new BufferedImage(
                image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        int pix = 0, p=0;
        for (int y=0; y<image.getHeight()-2; y+=2) {
            for (int x=0; x<image.getWidth()-2; x+=2) {
                pix = (int)((image.getRGB(x, y)& 0xFF)
                        + (image.getRGB(x+1, y)& 0xFF)
                        + (image.getRGB(x, y+1)& 0xFF)
                        + (image.getRGB(x+1, y+1)& 0xFF))/4;
                p = (255<<24) | (pix<<16) | (pix<<8) | pix;
                pixImg.setRGB(x,y,p);
                pixImg.setRGB(x+1,y,p);
                pixImg.setRGB(x,y+1,p);
                pixImg.setRGB(x+1,y+1,p);
            }
        }
        return pixImg;
    }

    public BufferedImage pixelate_2 (@NotNull BufferedImage image, int blockSize) {

        imgConsole.consoleLog("Pixelating Image with block size " + blockSize + ".");

        int width = image.getWidth();
        int height = image.getHeight();


        if (blockSize <= 0) {
            imgConsole.consoleLog("Insufficient Block Size:");

            throw new IllegalArgumentException("Block size must be greater than 0.");


        }


        BufferedImage temp = new BufferedImage(width / blockSize, height / blockSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = temp.createGraphics();
        g2d.drawImage(image, 0, 0, width / blockSize, height / blockSize, null);
        g2d.dispose();


        BufferedImage pixelated = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2d = pixelated.createGraphics();
        g2d.drawImage(temp, 0, 0, width, height, null);
        g2d.dispose();

        return pixelated;
    }

    public BufferedImage blur (@NotNull BufferedImage img) {
        imgConsole.consoleLog("Applying Blur To Image");
        BufferedImage blurImg = new BufferedImage(
                img.getWidth()-2, img.getHeight()-2, BufferedImage.TYPE_BYTE_GRAY);
        int pix = 0;
        for (int y=0; y<blurImg.getHeight(); y++) {
            for (int x=0; x<blurImg.getWidth(); x++) {
                pix = (int)(4*(img.getRGB(x+1, y+1)& 0xFF)
                        + 2*(img.getRGB(x+1, y)& 0xFF)
                        + 2*(img.getRGB(x+1, y+2)& 0xFF)
                        + 2*(img.getRGB(x, y+1)& 0xFF)
                        + 2*(img.getRGB(x+2, y+1)& 0xFF)
                        + (img.getRGB(x, y)& 0xFF)
                        + (img.getRGB(x, y+2)& 0xFF)
                        + (img.getRGB(x+2, y)& 0xFF)
                        + (img.getRGB(x+2, y+2)& 0xFF))/16;
                int p = (255<<24) | (pix<<16) | (pix<<8) | pix;
                blurImg.setRGB(x,y,p);
            }
        }
        return blurImg;
    }

    public BufferedImage heavyblur (@NotNull BufferedImage img) {
        imgConsole.consoleLog("Applying Heavy Blur To Image");

        BufferedImage blurImg = new BufferedImage(
                img.getWidth()-4, img.getHeight()-4, BufferedImage.TYPE_BYTE_GRAY);
        int pix = 0;
        for (int y=0; y<blurImg.getHeight(); y++) {
            for (int x=0; x<blurImg.getWidth(); x++) {
                pix = (int)(
                        10*(img.getRGB(x+3, y+3)& 0xFF)
                                + 6*(img.getRGB(x+2, y+1)& 0xFF)
                                + 6*(img.getRGB(x+1, y+2)& 0xFF)
                                + 6*(img.getRGB(x+2, y+3)& 0xFF)
                                + 6*(img.getRGB(x+3, y+2)& 0xFF)
                                + 4*(img.getRGB(x+1, y+1)& 0xFF)
                                + 4*(img.getRGB(x+1, y+3)& 0xFF)
                                + 4*(img.getRGB(x+3, y+1)& 0xFF)
                                + 4*(img.getRGB(x+3, y+3)& 0xFF)
                                + 2*(img.getRGB(x, y+1)& 0xFF)
                                + 2*(img.getRGB(x, y+2)& 0xFF)
                                + 2*(img.getRGB(x, y+3)& 0xFF)
                                + 2*(img.getRGB(x+4, y+1)& 0xFF)
                                + 2*(img.getRGB(x+4, y+2)& 0xFF)
                                + 2*(img.getRGB(x+4, y+3)& 0xFF)
                                + 2*(img.getRGB(x+1, y)& 0xFF)
                                + 2*(img.getRGB(x+2, y)& 0xFF)
                                + 2*(img.getRGB(x+3, y)& 0xFF)
                                + 2*(img.getRGB(x+1, y+4)& 0xFF)
                                + 2*(img.getRGB(x+2, y+4)& 0xFF)
                                + 2*(img.getRGB(x+3, y+4)& 0xFF)
                                + (img.getRGB(x, y)& 0xFF)
                                + (img.getRGB(x, y+2)& 0xFF)
                                + (img.getRGB(x+2, y)& 0xFF)
                                + (img.getRGB(x+2, y+2)& 0xFF))/74;
                int p = (255<<24) | (pix<<16) | (pix<<8) | pix;
                blurImg.setRGB(x,y,p);
            }
        }
        return blurImg;
    }

    public BufferedImage adjustBrightness(@NotNull BufferedImage image, double brightnessFactor) {
        imgConsole.consoleLog("Applying Brightness To Image");

        BufferedImage brightImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = new Color(image.getRGB(x, y));
                int red = (int) (color.getRed() * brightnessFactor);
                int green = (int) (color.getGreen() * brightnessFactor);
                int blue = (int) (color.getBlue() * brightnessFactor);

                // Ensure the values are within the valid range [0, 255]
                red = Math.min(255, Math.max(0, red));
                green = Math.min(255, Math.max(0, green));
                blue = Math.min(255, Math.max(0, blue));

                // Set the adjusted color back to the image
                brightImage.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }

        return brightImage;
    }

    public BufferedImage dynamicBlur(BufferedImage image, int bluringMultiplier) {
        //bluringMultiplier must be grater than 3


        if(bluringMultiplier>=5){
            imgConsole.consoleLog("Applying Dynamic Blur To Image");
            float blurMultiplier = 10;

            float[] matrix = createGaussianKernel( bluringMultiplier, blurMultiplier);

            Kernel kernel = new Kernel(5, 5, matrix);
            ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
            BufferedImage blurredImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
            op.filter(image, blurredImage);
            return blurredImage;

        }
        else {
            imgConsole.consoleLog("Error : The Blur Multiplier is Too Low...!!!!");
            return  null;
        }
    }

    private static float[] createGaussianKernel(int size, float multiplier) {
        float[] matrix = new float[size * size];
        int center = size / 2;
        float sum = 0;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                float dx = x - center;
                float dy = y - center;
                float value = (float) Math.exp(-(dx * dx + dy * dy) / (2 * multiplier * multiplier));
                matrix[y * size + x] = value;
                sum += value;
            }
        }

        // Normalize the kernel
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] /= sum;
        }

        return matrix;
    }

    public BufferedImage cropImage(BufferedImage image, int x, int y, int width, int height) {
        if (x < 0 || y < 0 || x + width > image.getWidth() || y + height > image.getHeight()) {
            imgConsole.consoleLog("Corping Image");

            throw new IllegalArgumentException("Crop region is out of bounds.");
        }

        return image.getSubimage(x, y, width, height);
    }

    public BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
        imgConsole.consoleLog("Resizing Image");

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);

        g2d.dispose();

        return resizedImage;
    }

    public void saveBufferedImageAsJPG(BufferedImage image, String filePath) throws IOException {


        if(image == null){

            imgConsole.consoleLog("Error Image Save Unsuccessfull :Image is Null");

        }else{
            File file = new File(filePath);
            boolean result = ImageIO.write(image, "jpg", file);
            imgConsole.consoleLog("Saving Image");
            try {
                if (!result) {

                    throw new IOException("Failed to write image to file: " + filePath);
                }

            } catch (IOException e) {

                e.printStackTrace();
                imgConsole.consoleLog("Error Image Save Unsuccessfull : " + e.getMessage());

            }
            imgConsole.consoleLog("Image successfully saved as JPG at: " + filePath);



        }

    }



}
