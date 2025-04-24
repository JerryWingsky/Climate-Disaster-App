package com.nono.groupproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Homepage7FeatureKeysGUIConsole extends JFrame {

/*  public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        Homepage7FeatureKeysGUIConsole homePage = new Homepage7FeatureKeysGUIConsole();
        homePage.createAndShowGUI();
});
}*/

    public void createAndShowGUI() {
        setTitle("Select Feature");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));
        panel.setPreferredSize(new Dimension(400, 400));

        String[] featureLabels = {
        "Admin Registration",
        "Volunteer Registration",
        "Disaster Report",
        "Safe Shelter",
        "Fund Raising",
        "Disaster Guide",
        "Weather Prediction",
};

        for (String label : featureLabels) {
            JButton button = createFeatureButton(label);
            panel.add(button);
}

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
}

    private JButton createFeatureButton(String label) {
        JButton button = new JButton(label);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(new Color(124, 200, 255));
        button.addActionListener((ActionEvent e) -> handleFeatureButton(label));
        return button;
}

    private void handleFeatureButton(String feature) {
        switch (feature) {
            case "Admin Registration" -> openAdminAppGUI();
            case "Volunteer Registration" -> openVolunteerAppGUI();
            case "Disaster Report" -> openDisasterReportGUI();
            case "Safe Shelter" -> openSafeShelterGUI();
            case "Fund Raising" -> openFundRaisingGUI();
            case "Disaster Guide" -> openDisasterGuideGUI();
            case "Weather Prediction" -> openWeatherPredictionGUI();
}
}

    private void openAdminAppGUI() {
        SwingUtilities.invokeLater(() -> {
        AdminRegistrationGUI adminWindowGUI = new AdminRegistrationGUI();
        adminWindowGUI.createAndShowGUI();
});
}

    private void openVolunteerAppGUI() {
        VolunteerRegistrationGUI volunteerAppGUI = new VolunteerRegistrationGUI();
        volunteerAppGUI.createAndShowGUI();
}

    private void openDisasterReportGUI() {
        DisasterReportGUI disasterReportGUI = new DisasterReportGUI();
        disasterReportGUI.createAndShowGUI();
}

    private void openSafeShelterGUI() {
        SafeShelterGUI safeShelterGUI = new SafeShelterGUI();
        safeShelterGUI.createAndShowGUI();
}

    private void openFundRaisingGUI() {
        FundRaisingGUI fundRaisingGUI = new FundRaisingGUI();
        fundRaisingGUI.createAndShowGUI();
}

    private void openDisasterGuideGUI() {
        DisasterGuideGUI disasterGuideGUI = new DisasterGuideGUI();
        disasterGuideGUI.createAndShowGUI();
}

    private void openWeatherPredictionGUI() {
        WeatherPredictionGUI weatherPredictionGUI = new WeatherPredictionGUI();
        weatherPredictionGUI.createAndShowGUI();
}
}
