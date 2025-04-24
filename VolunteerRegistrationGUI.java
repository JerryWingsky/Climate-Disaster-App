package com.nono.groupproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class VolunteerRegistrationGUI extends JFrame {

    private final JTextField nameField, addressField, phoneNumberField;
    private final JRadioButton maleRadioButton, femaleRadioButton;
    private final ButtonGroup sexButtonGroup;

    public VolunteerRegistrationGUI() {
        setTitle("Volunteer Registration");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

       JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 10, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(1, 8, 10, 8));
        
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);
        nameField.setColumns(27);

        panel.add(new JLabel("Address:"));
        addressField = new JTextField();
        panel.add(addressField);

        panel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        panel.add(phoneNumberField);

        panel.add(new JLabel("Sex:"));
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        sexButtonGroup = new ButtonGroup();
        sexButtonGroup.add(maleRadioButton);
        sexButtonGroup.add(femaleRadioButton);
        panel.add(maleRadioButton);
        panel.add(femaleRadioButton);

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
        if (nameField.getText().isEmpty() || addressField.getText().isEmpty() || phoneNumberField.getText().isEmpty() || (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected())) {
            JOptionPane.showMessageDialog(this, "Error, fill in the form first.", "Registration Error", JOptionPane.ERROR_MESSAGE);
}       else {
            JOptionPane.showMessageDialog(this, "Registration Completed!");
            this.dispose();
}
}

/*  public static void main(String[] args) {
        new VolunteerRegistrationGUI();
}*/

    void createAndShowGUI() {
}
}
