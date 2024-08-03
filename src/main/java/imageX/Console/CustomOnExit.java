package imageX.Console;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CustomOnExit {


    public static void setupCloseOperation(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                handleWindowClosing(frame);
            }
        });
    }

    private static void handleWindowClosing(JFrame frame) {
        ImageXConsole consoleX = new ImageXConsole();
        int response = JOptionPane.showConfirmDialog(frame,
                "Do you want to save changes before exiting?",
                "Confirm Exit",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            // Save changes here

            // Example: saveCurrentValues();
            JOptionPane.showMessageDialog(frame, "Exiting..!");
            consoleX.consoleLogEnd();
            System.exit(0);  // Exit after saving
        } else if (response == JOptionPane.NO_OPTION) {
            // Exit without saving
            consoleX.consoleLogEnd();
            System.exit(0);
        } else if (response == JOptionPane.CANCEL_OPTION) {
            // Do nothing, user cancelled the exit
            // You can also hide the window if you want to
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
}
