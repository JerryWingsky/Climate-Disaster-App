package com.nono.groupproject;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AdminEditPanel extends JFrame {
    private final JTextArea textArea;
    private final JButton openButton;
    private final JButton saveButton;
    private final JButton returnButton;
    private File selectedFile;

    public AdminEditPanel() {
        setTitle("File Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        openButton = new JButton("Open File");
        openButton.addActionListener(e -> selectFile());

        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveToFile());
        saveButton.setEnabled(false);

        returnButton = new JButton("Return");
        returnButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(returnButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
}

    private void selectFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            loadFile();
            saveButton.setEnabled(true);
}
}

    private void loadFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
}
            textArea.setText(content.toString());
}       catch (IOException e) {
}
}

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "File saved successfully!", "Save", JOptionPane.INFORMATION_MESSAGE);
}       catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving the file." + e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
}
}

/*  public static void main(String[] args) {
        new AdminEditPanel();
}*/

    void createAndShowGUI() {
}
}
