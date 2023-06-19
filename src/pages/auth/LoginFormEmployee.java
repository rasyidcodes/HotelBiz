package pages.auth;

import config.DatabaseConnector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFormEmployee {
    private JFrame loginFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFormEmployee() {
        loginFrame = new JFrame("Employee Login");
        JPanel loginPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        loginPanel.setBackground(new Color(155, 89, 182));
        loginFrame.setSize(800, 600);
        loginFrame.setPreferredSize(new Dimension(800, 600));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(155, 89, 182));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.white);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.white);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                // Create an instance of the GuestAuthProvider and authenticate the user
                AuthProvider authProvider = new EmployeeAuthProvider(new DatabaseConnector());
                Employee user = (Employee) authProvider.authenticate(username, new String(password));

                if (user != null) {
                    // Authentication successful
                    String role = null;
                    if (user.getAccessLevel() == 1){
                        role = "admin";
                    }
                    
                    JOptionPane.showMessageDialog(loginFrame, "Login successful!\nWelcome, " + role,
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

        JButton signUpButton = new JButton("Sign up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                SignUpfFormEmployee loginFormEmployee = new SignUpfFormEmployee();
                loginFormEmployee.showSignupEmployeeForm();
            }
        });


        JButton guestLoginButton = new JButton("Guest Login");
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
        loginPanel.add(signUpButton);

        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(guestLoginButton);


        mainPanel.add(loginPanel, constraints);

        loginFrame.add(mainPanel);
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
                LoginFormEmployee loginFormEmployee = new LoginFormEmployee();
                loginFormEmployee.showLoginForm();
            }
        });
    }
}
