package pages.auth;

import config.DatabaseConnector;
import pages.guest.GuestMainPage;
import pages.guest.bookRoom.RoomFeature;
import pages.guest.orderFood.OrderFood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFormGuest {
    private JFrame loginFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFormGuest() {
        loginFrame = new JFrame("Guest Login");
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

        JPanel loginPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        loginPanel.setBackground(new Color(155, 89, 182));

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
                AuthProvider authProvider = new GuestAuthProvider(new DatabaseConnector());
                Guest user = (Guest) authProvider.authenticate(username, new String(password));

                if (user != null) {
                    // Authentication successful
                    JOptionPane.showMessageDialog(loginFrame, "Login successful!\nWelcome, " + user.getFullName(),
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                    loginFrame.dispose();
                    //SET PROPS
                    GuestMainPage.guests = user;
                    OrderFood.guest = user;
                    RoomFeature.guest = user;

                    GuestMainPage guestMainPage = new GuestMainPage();
                    guestMainPage.showLoginForm();

                    // Display the next form
//                    nextForm.setVisible(true);
                } else {
                    // Authentication failed
                    JOptionPane.showMessageDialog(loginFrame, "Invalid username or password!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                // Clear the input fields after login attempt
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        JButton signupGuestButton = new JButton("Signup guest");

        signupGuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                SignUpFormGuest signUpFormGuest = new SignUpFormGuest();
                signUpFormGuest.showSignupGuestForm();
            }
        });
        JButton adminLoginButton = new JButton("employee login");
        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                LoginFormEmployee loginFormEmployee = new LoginFormEmployee();
                loginFormEmployee.showLoginForm();
            }
        });



        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(loginButton);


        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(signupGuestButton);


        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(adminLoginButton);

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
                LoginFormGuest loginFormGuest = new LoginFormGuest();
                loginFormGuest.showLoginForm();
            }
        });
    }
}
