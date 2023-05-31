package auth;

import config.DatabaseConnector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFormAdmin {
    private JFrame loginFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFormAdmin() {
        loginFrame = new JFrame("Admin Login");
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login as Admin");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                // Create an instance of the GuestAuthProvider and authenticate the user
                AuthProvider authProvider = new AdminAuthProvider(new DatabaseConnector());
                Admin user = (Admin) authProvider.authenticate(username, new String(password));

                if (user != null) {
                    // Authentication successful
                    JOptionPane.showMessageDialog(loginFrame, "Login successful!\nWelcome, " + user.getAccessLevel(),
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Authentication failed
                    JOptionPane.showMessageDialog(loginFrame, "Invalid username or password!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        JButton guestLoginButton = new JButton("Login as Guest");
        guestLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                LoginFormGuest loginFormGuest = new LoginFormGuest();
                loginFormGuest.showLoginForm();
            }
        });

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(loginButton);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(guestLoginButton);

        loginFrame.add(loginPanel);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.pack();
    }

    public void showLoginForm() {
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginFormAdmin loginFormAdmin = new LoginFormAdmin();
                loginFormAdmin.showLoginForm();
            }
        });
    }
}
