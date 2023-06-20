package pages.auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import config.DatabaseConnector;
import pages.guest.GuestMainPage;
import pages.guest.bookRoom.RoomFeature;
import pages.guest.orderFood.OrderFood;

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
        JPanel signUpPanel = new JPanel(new GridLayout(15, 2, 10, 10));
        signUpPanel.setBackground(new Color(155, 89, 182));
        signUpFrame.setSize(800, 600);
        signUpFrame.setPreferredSize(new Dimension(800, 600));

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
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.white);
        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setForeground(Color.white);
        JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
        dateOfBirthLabel.setForeground(Color.white);
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(Color.white);
        JLabel NIKLabel = new JLabel("NIK:");
        NIKLabel.setForeground(Color.white);
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(Color.white);
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setForeground(Color.white);
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setForeground(Color.white);
        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setForeground(Color.white);
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setForeground(Color.white);
        JLabel guestTypeLabel = new JLabel("Guest Type:");
        guestTypeLabel.setForeground(Color.white);

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
//                int age = Integer.parseInt(ageField.getText());
                String phoneNumber = phoneNumberField.getText();
                String country = countryField.getText();
                String city = cityField.getText();
                String guestType = guestTypeField.getText();




                if (ageField.getText().equals("") || username.equals("") ||
                        new String(password).equals("") ||
                        email.equals("") ||
                        fullName.equals("") ||
                        dateOfBirth.equals("") ||
                        gender.equals("") ||
                        NIK.equals("") ||
                        address.equals("") ||
                        phoneNumber.equals("") ||
                        country.equals("") ||
                        city.equals("") ||
                        guestType.equals("")) {
                    // Handle the case when the age field is empty
                    JOptionPane.showMessageDialog(signUpFrame, "Please fill all field!", "Error",
                            JOptionPane.ERROR_MESSAGE);

                }else{
                    int age;
                    try {
                        age = Integer.parseInt(ageField.getText());


                        if (Validator.validateEmail(email)){


                            AuthProvider authProvider = new GuestAuthProvider(new DatabaseConnector());
                            Guest user = (Guest) authProvider.signupGuest(username, password, email, fullName, dateOfBirth, gender, NIK, address,age, phoneNumber, country, city,guestType);


                            if (user != null) {
                                // Authentication successful
                                JOptionPane.showMessageDialog(signUpFrame, "Signup successful!\nWelcome, " + user.getFullName(),
                                        "Success", JOptionPane.INFORMATION_MESSAGE);

                                GuestMainPage.guests = user;
                                OrderFood.guest = user;
                                RoomFeature.guest = user;

                                signUpFrame.dispose();
                                GuestMainPage guestMainPage = new GuestMainPage();
                                guestMainPage.showLoginForm();
                            } else {
                                // Authentication failed
                                JOptionPane.showMessageDialog(signUpFrame, "Sign Up failed!", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }

                        }else {

                            JOptionPane.showMessageDialog(signUpFrame, "Invalid Email!", "Error",
                                    JOptionPane.ERROR_MESSAGE);


                        }

                    } catch (NumberFormatException x) {
                        JOptionPane.showMessageDialog(signUpFrame, "Age must number!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

//                AuthProvider authProvider = new GuestAuthProvider(new DatabaseConnector());
//                Guest user = (Guest) authProvider.signupGuest(username, password, email, fullName, dateOfBirth, gender, NIK, address,age, phoneNumber, country, city,guestType);
//
//
//                if (user != null) {
//                    // Authentication successful
//                    JOptionPane.showMessageDialog(signUpFrame, "Login successful!\nWelcome, " + user.getGuestType(),
//                            "Success", JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    // Authentication failed
//                    JOptionPane.showMessageDialog(signUpFrame, "Invalid username or password!", "Error",
//                            JOptionPane.ERROR_MESSAGE);
//                }


                // Save the guest data to the database
//                saveGuestData(username, new String(password), email, fullName, dateOfBirth, gender, NIK, address, age,
//                        phoneNumber, country, city, guestType);
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpFrame.dispose();
                LoginFormGuest loginFormGuest = new LoginFormGuest();
                loginFormGuest.showLoginForm();
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
        signUpPanel.add(new JLabel());
        signUpPanel.add(signUpButton);
        signUpPanel.add(new JLabel());
        signUpPanel.add(loginButton);

        mainPanel.add(signUpPanel, constraints);

        signUpFrame.add(mainPanel);
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        signUpFrame.setSize(400, 500);
//        signUpFrame.setLocationRelativeTo(null);
        signUpFrame.setVisible(true);
    }

    public void showSignupGuestForm() {
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
