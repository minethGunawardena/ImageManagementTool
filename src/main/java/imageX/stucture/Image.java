package imageX.stucture;
import  imageX.Console.ImageXConsole;
import java.awt.image.BufferedImage;

public class Image {
    ImageNode head;
    ImageNode tail;
    ImageXConsole consoleX;

    public Image(){
        head = null;
        tail = null;
        consoleX = new ImageXConsole();
    }
    static class ImageNode{
        String imageName;
        BufferedImage imageData;
        ImageNode nextVariant;
        ImageNode previousVariant;

        public ImageNode(String ImageName,BufferedImage ImageData){
            imageName =ImageName;
            imageData = ImageData;
            previousVariant =null;
            nextVariant = null;
        }

    }

    public void addImageVariant(String ImageName,BufferedImage ImageData){
        //adds to end of the tail of the lnked list
        ImageNode newImgeNode = new ImageNode(ImageName,ImageData);
        if(head == null){//means the linked list is empty
            head = newImgeNode;
            tail = newImgeNode;
            consoleX.consoleLog(ImageName+" is The Original Variant now");
            consoleX.consoleLog(ImageName+" is added to the ImageNode Linked List");
        }else{
            tail.nextVariant = newImgeNode;
            newImgeNode.previousVariant = tail;
            tail = newImgeNode;
            consoleX.consoleLog(ImageName+" is added to the ImageNode Linked List");
        }
    }
    public void addOriginalImage(String ImageName,BufferedImage ImageData) {
        ImageNode newImgeNode = new ImageNode(ImageName,ImageData);
        //means the linked list is empty
        if (head == null) {
            head = newImgeNode;
            tail = newImgeNode;
        } else {
            newImgeNode.nextVariant = head;
            head.previousVariant = newImgeNode;
            head = newImgeNode;
        }
    }
    public void removeImageNode(ImageNode node) {
        if (node == null) return;

        if (node == head) {
            head = node.nextVariant;
            if (head != null) {
                head.previousVariant = null;
            }
        } else if (node == tail) {
            tail = node.previousVariant;
            if (tail != null) {
                tail.nextVariant = null;
            }
        } else {
            node.previousVariant.nextVariant = node.nextVariant;
            node.nextVariant.previousVariant = node.previousVariant;
        }
    }


    public void removeByImageName(String ImageName) {
        ImageNode current = head;
        if(head == null){
            consoleX.consoleLog("Image Node Linked list is Null Nothisng to Delete");
        }
        else{
            while (current != null) {
                if (current.imageName.equals(ImageName)) {
                    removeImageNode(current);
                    return; // Node found and removed, exit method
                }
                current = current.nextVariant;
            }

            consoleX.consoleLog(ImageName+" Node is Deleted From the Linked List");

        }

    }


}
