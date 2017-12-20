package org.test.agileengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ImagesDifferenceGUI extends JFrame {

    private JFileChooser imageOneChooser = new JFileChooser();
    private JFileChooser imageTwoChooser = new JFileChooser();
    private JButton processImageDifferencesButton = new JButton("Process image differences");

    public ImagesDifferenceGUI() {
        super("Simple Example");
        this.setBounds(0, 0, 1050, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());

        processImageDifferencesButton.setPreferredSize(new Dimension(200, 30));
        processImageDifferencesButton.addActionListener(new ProcessImageDifferencesButtonEventListener());

        container.add(imageOneChooser);
        container.add(imageTwoChooser);
        container.add(processImageDifferencesButton);

        imageOneChooser.setCurrentDirectory(new java.io.File("."));
        imageTwoChooser.setCurrentDirectory(new java.io.File("."));
    }

    class ProcessImageDifferencesButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                ImagesProcessor processor = new ImagesProcessor(imageOneChooser.getSelectedFile(),
                        imageTwoChooser.getSelectedFile());
        }
    }


}
