package com.nono.groupproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class AdminRegistrationGUI extends JFrame {

    private final JTextField nameField;
    private final JTextField emailField;
    private final JTextField phoneNumberField;
   

    public AdminRegistrationGUI() {
        setTitle("Admin Registration");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 10, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);
        nameField.setColumns(25);

        panel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        panel.add(phoneNumberField);
        
        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);
        
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> handleRegistration(e));
        panel.add(registerButton);
        
        JButton rButton = new JButton("Return");
        rButton.addActionListener(e -> dispose());
        panel.add(rButton);
        
                
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
}

    private void handleRegistration(ActionEvent e) {
        if (nameField.getText().isEmpty() || phoneNumberField.getText().isEmpty() || emailField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error, please fill in the form first.", "Registration Error", JOptionPane.ERROR_MESSAGE);
}       else {
            JOptionPane.showMessageDialog(this, "Registration Completed!");
            this.dispose();
}
}

/*  public static void main(String[] args) {
        new AdminRegistrationGUI();
}*/

    void createAndShowGUI() {
}
}

