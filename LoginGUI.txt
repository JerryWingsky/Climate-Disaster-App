package GroupProjectOOP2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.util.Properties;

public class LoginGUI extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.createAndShowGUI();
});
}

    public void createAndShowGUI() {
        setTitle("Disaster Guide App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 20, 20));

        JLabel LoginAs = new JLabel("Login as:");
        LoginAs.setFont(new Font("Arial", Font.PLAIN, 20));
        LoginAs.setBorder(BorderFactory.createEmptyBorder(20, 5, 5, 20));

        panel.add(LoginAs);

        JButton buttonAdmin = createLoginButton("Admin");
        buttonAdmin.setBackground(Color.LIGHT_GRAY);
        panel.add(buttonAdmin);

        JButton buttonUser = createLoginButton123("User");
        buttonUser.setBackground(Color.LIGHT_GRAY);
        panel.add(buttonUser);

        setContentPane(panel);

        setPreferredSize(new Dimension(290, 200));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
}

    private JButton createLoginButton(String label) {
        JButton button = new JButton(label);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(new Color(220, 220, 220));
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.addActionListener((ActionEvent e) -> handleLoginButton(label));
        return button;
}

    private JButton createLoginButton123(String label) {
        JButton button = new JButton(label);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(new Color(220, 220, 220));
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.addActionListener((ActionEvent e) -> handleLoginButton123(label));
        return button;
}

    private boolean validateCredentials(String inputUser, String inputPass) {
        try {
            // Read the credentials from the credentials.txt file
            Properties props = new Properties();
            FileInputStream in = new FileInputStream("credentials.txt");
            props.load(in);
            in.close();

            String fileUser = props.getProperty("username");
            String filePass = props.getProperty("password");

            // Check if input matches credentials from the file
            return inputUser.equals(fileUser) && inputPass.equals(filePass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error reading credentials file.");
            return false;
}
}

    private void handleLoginButton(String loginType) {
        if (loginType.equals("Admin")) {
            String username = JOptionPane.showInputDialog(this, "Enter username:");
            String password = JOptionPane.showInputDialog(this, "Enter password:");

            if (username != null && password != null) {
                if (validateCredentials(username, password)) {
                    openAdminWindow();        
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
}
}  
}
}

    private void handleLoginButton123(String loginType) {
        if (loginType.equals("User")) {
            openUserWindow();
            dispose();
}
}

    private void openAdminWindow() {
        SwingUtilities.invokeLater(() -> {
            AdminEditPanel adminWindow = new AdminEditPanel();
            adminWindow.createAndShowGUI();
});
}

    private void openUserWindow() {
        SwingUtilities.invokeLater(() -> {
            Homepage7FeatureKeysGUIConsole userWindow = new Homepage7FeatureKeysGUIConsole();
            userWindow.createAndShowGUI();
});
}
}
