package com.nono.groupproject;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherPredictionGUI extends JFrame {
    private final JTextArea textArea;
    private final JButton startButton;
    private final JButton stopButton;
    private final JButton returnButton;
    private ScheduledExecutorService executorService;
    private volatile boolean isPredicting;
    private Calendar currentDate;

    public WeatherPredictionGUI() {
        setTitle("Weather Prediction");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea(15, 40);
        textArea.setEditable(false);

        startButton = new JButton("Start Prediction");
        startButton.addActionListener(e -> startPrediction());

        stopButton = new JButton("Stop Prediction");
        stopButton.addActionListener(e -> stopPrediction());
        stopButton.setEnabled(false);

        returnButton = new JButton("Return");
        returnButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(returnButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
}

    private void startPrediction() {
        isPredicting = true;
        startButton.setEnabled(false);
        stopButton.setEnabled(true);

        if (currentDate == null) {
            currentDate = Calendar.getInstance();
}

        executorService = Executors.newSingleThreadScheduledExecutor();
        int iterations = 1;
        do {executorService.scheduleAtFixedRate(this::generatePrediction, 0, 5, TimeUnit.SECONDS);
            iterations--;
}       while (iterations > 0);
}

    private void stopPrediction() {
        isPredicting = false;
        if (executorService != null) {
            executorService.shutdown();
}

        startButton.setEnabled(true);
        stopButton.setEnabled(false);
}

    private void generatePrediction() {
        if (!isPredicting) {
            stopPrediction();
            return;
}

        SwingUtilities.invokeLater(() -> {
            String prediction = generateRandomPrediction();
            String formattedDate = getCurrentDate();
            textArea.append(formattedDate + " - " + prediction + "\n");
            currentDate.add(Calendar.DAY_OF_MONTH, 1);
});
}

    private String generateRandomPrediction() {
        String[] weatherConditions = {"Sunny", "Cloudy", "Rainy", "Stormy"};
        Random random = new Random();
        int randomIndex = random.nextInt(weatherConditions.length);
        return "Prediction: " + weatherConditions[randomIndex];
}

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd (EEEE)");
        return dateFormat.format(currentDate.getTime());
}

/*    public static void main(String[] args) {
        new WeatherPredictionGUI();
}*/

    void createAndShowGUI() {
}
}
