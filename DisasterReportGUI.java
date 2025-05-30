package com.nono.groupproject;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisasterReportGUI extends JFrame {
    
    private final JTextField locationField, yourNameField, phoneNumberField;
    private final JComboBox<String> disasterTypeComboBox;
    private ArrayList<DisasterReport> reportList;

    public DisasterReportGUI() {
        setTitle("Report Disaster");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        ArrayList<DisasterReport> reportList = new ArrayList<DisasterReport>();
        
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(1, 8,5, 8));
        setPreferredSize(new Dimension(400, 400));
        
        panel.setLayout(new GridLayout(10, 10, 10, 10));
        
        panel.add(new JLabel("Your name:"));
        yourNameField = new JTextField();
        panel.add(yourNameField);
        
        panel.add(new JLabel("Phone Number of Witness:"));
        phoneNumberField = new JTextField();
        panel.add(phoneNumberField);
        
        panel.add(new JLabel("Location:"));
        locationField = new JTextField(20);
        panel.add(locationField);
        
        panel.add(new JLabel("Disaster Type:"));
        String[] disasterTypes = {"Earthquake", "Typhoon", "Flood", "Fire", "Other"};
        disasterTypeComboBox = new JComboBox<>(disasterTypes);
        panel.add(disasterTypeComboBox);
       
        JButton submitButton = new JButton("Submit Report");
        submitButton.addActionListener(e -> handleRegistration(e));
        panel.add(submitButton);
        
        JButton rButton = new JButton("Return");
        rButton.addActionListener(e -> dispose());
        panel.add(rButton);
        
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);  
        
        reportList = new ArrayList<>();
}

    private void handleRegistration(ActionEvent e) { 
        if (yourNameField.getText().isEmpty() || phoneNumberField.getText().isEmpty() || locationField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error, fill the form first.", "Submission Error", JOptionPane.ERROR_MESSAGE);
}       else {
            JOptionPane.showMessageDialog(this, "Report Submitted!");
            dispose();
}
}
    
/*  public static void main(String[] args) {
        new DisasterReportGUI();
}*/

    void createAndShowGUI() {
}
}
