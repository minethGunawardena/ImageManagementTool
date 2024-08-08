package imageX.Console;

import javax.swing.*;
import java.awt.*;
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
        JDialog dialog = new JDialog(frame, "Exiting Program....!", false);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(new Dimension(500, 20));
        JLabel messageLabel = new JLabel("Exiting Program..!!", JLabel.CENTER);
        dialog.add(messageLabel, BorderLayout.CENTER);



        int response = JOptionPane.showConfirmDialog(frame,
                "Do you Want To Quit the Program...?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            // Save changes here
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            //JOptionPane.showMessageDialog(frame, "Exiting..!");
            consoleX.consoleLogEnd();
            System.exit(0);  // Exit after saving
        } else if (response == JOptionPane.NO_OPTION) {
            // Exit without saving

            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
}
