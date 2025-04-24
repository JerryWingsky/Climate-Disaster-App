package com.nono.groupproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FundRaisingGUI extends JFrame {

    private final JTextField nameField, amountField, phoneNumberField;
    private final JComboBox<String> paymentMethodComboBox;
    private final JButton donateButton;

    public FundRaisingGUI() {
        setTitle("Fund Raising");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Your Name:"));
        nameField = new JTextField();
        panel.add(nameField);
        
        panel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        panel.add(phoneNumberField);

        panel.add(new JLabel("Amount to Donate (RM):"));
        amountField = new JTextField();
        panel.add(amountField);

        panel.add(new JLabel("Payment Method:"));
        String[] paymentMethods = {"Credit Card", "PayPal", "Bank Transfer", "Other"};
        paymentMethodComboBox = new JComboBox<>(paymentMethods);
        panel.add(paymentMethodComboBox);

        JButton rButton = new JButton("Return");
        rButton.addActionListener(e -> dispose());
        panel.add(rButton);
         
        donateButton = new JButton("Donate");
        donateButton.addActionListener(new ActionListener() {
        @Override
    public void actionPerformed(ActionEvent e) {
        handleDonation();
}
});
        
        panel.add(donateButton);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
}

    private void handleDonation() {
        String name = nameField.getText();
        String amountString = amountField.getText();
        String phoneNumber =  phoneNumberField.getText();
        String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();

        if (name.isEmpty() || amountString.isEmpty() || phoneNumber.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill the form.");
        return;
}

        try {
            double amount = Double.parseDouble(amountString);

            String donationMessage = String.format("Thank you %s for your donation of RM%.2f using %s!", name, amount, paymentMethod);
            JOptionPane.showMessageDialog(this, donationMessage);
            dispose();

            nameField.setText("");
            amountField.setText("");
            paymentMethodComboBox.setSelectedIndex(0);

}       catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid donation amount.");
}
}

/*    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        new FundRaisingGUI();
}
});
}*/

    void createAndShowGUI() {     
}
}
