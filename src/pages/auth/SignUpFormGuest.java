package pages.auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import config.DatabaseConnector;
public class SignUpFormGuest {
    private JFrame signUpFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField fullNameField;
    private JTextField dateOfBirthField;
    private JTextField genderField;
    private JTextField NIKField;
    private JTextField addressField;
    private JTextField ageField;
    private JTextField phoneNumberField;
    private JTextField countryField;
    private JTextField cityField;
    private JTextField guestTypeField;

    public SignUpFormGuest() {
        signUpFrame = new JFrame("Guest Sign Up");
        JPanel signUpPanel = new JPanel(new GridLayout(14, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel fullNameLabel = new JLabel("Full Name:");
        JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel NIKLabel = new JLabel("NIK:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel countryLabel = new JLabel("Country:");
        JLabel cityLabel = new JLabel("City:");
        JLabel guestTypeLabel = new JLabel("Guest Type:");

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        emailField = new JTextField(20);
        fullNameField = new JTextField(20);
        dateOfBirthField = new JTextField(20);
        genderField = new JTextField(20);
        NIKField = new JTextField(20);
        addressField = new JTextField(20);
        ageField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        countryField = new JTextField(20);
        cityField = new JTextField(20);
        guestTypeField = new JTextField(20);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                String email = emailField.getText();
                String fullName = fullNameField.getText();
                String dateOfBirth = dateOfBirthField.getText();
                String gender = genderField.getText();
                String NIK = NIKField.getText();
                String address = addressField.getText();
                int age = Integer.parseInt(ageField.getText());
                String phoneNumber = phoneNumberField.getText();
                String country = countryField.getText();
                String city = cityField.getText();
                String guestType = guestTypeField.getText();


                AuthProvider authProvider = new GuestAuthProvider(new DatabaseConnector());
                Guest user = (Guest) authProvider.signupGuest(username, password, email, fullName, dateOfBirth, gender, NIK, address,age, phoneNumber, country, city,guestType);


                if (user != null) {
                    // Authentication successful
                    JOptionPane.showMessageDialog(signUpFrame, "Login successful!\nWelcome, " + user.getGuestType(),
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Authentication failed
                    JOptionPane.showMessageDialog(signUpFrame, "Invalid username or password!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }


                // Save the guest data to the database
//                saveGuestData(username, new String(password), email, fullName, dateOfBirth, gender, NIK, address, age,
//                        phoneNumber, country, city, guestType);
            }
        });

        signUpPanel.add(usernameLabel);
        signUpPanel.add(usernameField);
        signUpPanel.add(passwordLabel);
        signUpPanel.add(passwordField);
        signUpPanel.add(emailLabel);
        signUpPanel.add(emailField);
        signUpPanel.add(fullNameLabel);
        signUpPanel.add(fullNameField);
        signUpPanel.add(dateOfBirthLabel);
        signUpPanel.add(dateOfBirthField);
        signUpPanel.add(genderLabel);
        signUpPanel.add(genderField);
        signUpPanel.add(NIKLabel);
        signUpPanel.add(NIKField);
        signUpPanel.add(addressLabel);
        signUpPanel.add(addressField);
        signUpPanel.add(ageLabel);
        signUpPanel.add(ageField);
        signUpPanel.add(phoneNumberLabel);
        signUpPanel.add(phoneNumberField);
        signUpPanel.add(countryLabel);
        signUpPanel.add(countryField);
        signUpPanel.add(cityLabel);
        signUpPanel.add(cityField);
        signUpPanel.add(guestTypeLabel);
        signUpPanel.add(guestTypeField);
        signUpPanel.add(signUpButton);

        signUpFrame.add(signUpPanel);
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrame.setSize(400, 500);
        signUpFrame.setLocationRelativeTo(null);
        signUpFrame.setVisible(true);
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUpFormGuest();
            }
        });
    }
}
