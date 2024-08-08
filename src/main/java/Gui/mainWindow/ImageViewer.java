/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui.mainWindow;

import app.data.CurrentValues;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//import imageX.Console.CustomOnExit;
import app.data.LoadData;
import imageX.Console.*;
import imageX.image.imagefilters.imageFiltering;


public class ImageViewer extends javax.swing.JFrame {
    CurrentValues currentValues = new CurrentValues();
    File base = null;

    LoadData loadData = new LoadData("Settings/CurrentVariables/currentValues.json");
    ImageXConsole consoleX = new ImageXConsole();
    String currentSelectedImageName = null;
    String currentSelectedAlbumPath = null;
    public ImageViewer() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        CustomOnExit.setupCloseOperation(this);
        consoleX.consoleLog(currentValues.getCurrentFileSavePath());
        if(currentValues.getCurrentFileSavePath() == null){
            jLabel3.setText("No Album Selected..!");
        }else{
            jLabel3.setText(currentValues.getCurrentFileSavePath()+"...");

        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Nachlieli CLM", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Open an Image");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Nachlieli CLM", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Edit Image");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Nachlieli CLM", 3, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Create or  Select Album");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Nachlieli CLM", 3, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("View Full Image");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 204));
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Image View");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Nachlieli CLM", 3, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("<<Back");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Nachlieli CLM", 3, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Save Image");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Nachlieli CLM", 3, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Delete Image");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Image Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Album Not Selected...");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Image Current Location");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Selected Album :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        //Go to Image Editor
        if(currentSelectedImageName==null){
            JOptionPane.showMessageDialog(null,"Please Select an Image To Proceed To Edit..");
        }else{
            if(currentSelectedAlbumPath==null){
                JOptionPane.showMessageDialog(null,"Please Select an Album To Proceed To Editing This Image..");
            }else{
                this.hide();
                new ImgEditor();
            }
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        CurrentValues cv = new CurrentValues();
        if(cv.getCurrentSelectedImageName()!=null){
            File curntImg = new File(cv.getCurrentImagePath());
            base = curntImg;
            imageFiltering imageF = new imageFiltering(curntImg);
            imageF.displayImage(cv.getCurrentSelectedImageBufferedData());
        }else {
            JOptionPane.showMessageDialog(null,"Please Select an Image To View .");

        }

    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        File destinationFolder = new File("Temp/Images/");
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs(); // Create the folder if it does not exist
        }

        if (base == null) {
            JOptionPane.showMessageDialog(null, "No Image Selected To Delete");
            return;
        }

        int response = JOptionPane.showConfirmDialog(this,
                "Do you want to delete this image?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            try {
                Path sourcePath = base.toPath();
                Path targetPath = destinationFolder.toPath().resolve(sourcePath.getFileName());

                // Check if the file exists before trying to move it
                if (Files.exists(sourcePath)) {
                    Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                    consoleX.consoleLog("File moved to temporary directory successfully!");
                    JOptionPane.showMessageDialog(this, "File deleted successfully!");

                    // Update the UI and reset state
                    jLabel4.setText("Image Current Location");
                    jLabel2.setText("Image Name");
                    base = null; // Reset base reference
                } else {
                    JOptionPane.showMessageDialog(this, "File does not exist.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while moving the file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Delete operation canceled.");
        }



    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // save Image As Jpg
        CurrentValues cv = new CurrentValues();
        if(currentSelectedImageName==null){
            JOptionPane.showMessageDialog(null,"Please Select an Image To Proceed To Save To Album..");
        }else{
            if(currentSelectedAlbumPath==null){
                JOptionPane.showMessageDialog(null,"Please Select an Album To Proceed To Save This Image..");
            }else{
                File curntImg = new File(cv.getCurrentImagePath());
                imageFiltering imageF = new imageFiltering(curntImg);
                try {
                    imageF.saveBufferedImageAsJPG(cv.getCurrentSelectedImageBufferedData(),cv.getCurrentFileSavePath()+"/"+cv.getCurrentSelectedImageName());
                    if(new File(cv.getCurrentFileSavePath()+"/"+cv.getCurrentSelectedImageName()).exists()){
                        JOptionPane.showMessageDialog(this, "Image Save SuccessFull", "Imformation", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this, "Image Save Fail", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // the Back Button
        this.setVisible(false);
        new MainWindow();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("JPG Images", "jpg", "jpeg"));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedImage= fileChooser.getSelectedFile();
            base = selectedImage;
            imageFiltering Image = new imageFiltering(selectedImage);
            currentValues.setCurrentImagePath(selectedImage.getAbsolutePath());
            currentValues.setCurrentSelectedImageBufferedData(Image.bufferdImage);
            currentValues.setCurrentImageName(selectedImage.getName());
            jLabel4.setText(selectedImage.getAbsolutePath());
            jLabel2.setText(selectedImage.getName());
            currentSelectedImageName = selectedImage.getName();


            try {
                // Read and display the image
                BufferedImage image = ImageIO.read(selectedImage);
                if (image != null) {
                    jLabel1.setText(null);
                    BufferedImage image_Ajusted = Image.resizeImage(Image.bufferdImage,jLabel1.getWidth(),jLabel1.getHeight());
                    ImageIcon imgIcn = new ImageIcon(image_Ajusted);

                    jLabel1.setIcon(imgIcn);


                    pack(); // Adjust frame size to fit the image
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid image file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error loading image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Open Image Button
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser directoryChooser = new JFileChooser();
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = directoryChooser.showOpenDialog(this);
        String finalPath = null;

        if (returnValue == JFileChooser.APPROVE_OPTION) {

            File selectedDirectory = directoryChooser.getSelectedFile();


            String albumName = JOptionPane.showInputDialog(this, "Enter the name of the new album or Use an Existing album:");

            if (albumName != null && !albumName.trim().isEmpty()) {

                File newAlbum = new File(selectedDirectory, albumName);
                if (!newAlbum.exists()) {
                    boolean created = newAlbum.mkdirs();
                    if (created) {
                        finalPath = newAlbum.getAbsolutePath();
                        currentValues.setCurrentFileSavePath(finalPath);
                        JOptionPane.showMessageDialog(this, "Album created successfully: " + newAlbum.getAbsolutePath());
                        consoleX.consoleLog("Album created successfully: " + newAlbum.getAbsolutePath());
                        currentSelectedAlbumPath = newAlbum.getAbsolutePath();
                        jLabel3.setText(newAlbum.getAbsolutePath()+"...");


                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to create album.");
                        consoleX.consoleLog("Failed to create album.");
                    }
                } else {
                    //JOptionPane.showMessageDialog(this, "An album with this name already exists.");
                    int confirm = JOptionPane.showConfirmDialog(
                            this,
                            "The album '" + albumName + "' already exists. Do you want to use this existing folder?",
                            "Confirm Usage",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );
                    consoleX.consoleLog("An album with this name already exists.");
                    if (confirm == JOptionPane.YES_OPTION) {
                        // Use the existing folder
                        finalPath = newAlbum.getAbsolutePath();
                        currentSelectedAlbumPath = finalPath;
                        currentValues.setCurrentFileSavePath(finalPath);
                        JOptionPane.showMessageDialog(this, "Using existing album: " + finalPath);
                        try {
                            Thread.sleep(1000);
                            consoleX.consoleLog("Saving Data..");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        jLabel3.setText(newAlbum.getAbsolutePath()+"...");

                    } else {
                        JOptionPane.showMessageDialog(this, "Operation canceled.");
                    }


                }
            } else {
                JOptionPane.showMessageDialog(this, "Album name cannot be empty.");
                consoleX.consoleLog("Album name cannot be empty.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No directory selected.");
            consoleX.consoleLog("No directory selected.");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
