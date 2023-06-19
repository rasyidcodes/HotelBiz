package pages.auth;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import config.DatabaseConnector;
public class SignUpfFormEmployee {
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

    private JTextField salaryField;
    private JTextField roleField;

    public SignUpfFormEmployee() {
        signUpFrame = new JFrame("Employee Sign Up");

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

        JPanel signUpPanel = new JPanel(new GridLayout(15, 2, 10, 10));
        signUpPanel.setBackground(new Color(155, 89, 182));
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
        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setForeground(Color.white);
        JLabel roleLabel = new JLabel("role:");
        roleLabel.setForeground(Color.white);


        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        emailField = new JTextField(20);
        fullNameField = new JTextField(20);
        dateOfBirthField = new JTextField(20);
        genderField = new JTextField(20);
        salaryField = new JTextField(20);
        roleField = new JTextField(20);


        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpFrame.dispose();
                LoginFormEmployee loginFormEmployee = new LoginFormEmployee();
                loginFormEmployee.showLoginForm();
            }
        });

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


                if (username.equals("") ||
                        new String(password).equals("") ||
                        email.equals("") ||
                        fullName.equals("") ||
                        dateOfBirth.equals("") ||
                        gender.equals("") ||
                        salaryField.getText().equals("") ||
                        roleField.getText().equals("")
                        ) {
                    // Handle the case when the age field is empty
                    JOptionPane.showMessageDialog(signUpFrame, "Please fill all field!", "Error",
                            JOptionPane.ERROR_MESSAGE);

                }else{
                    int salary;
                    int role;
                    try {
                        salary = Integer.parseInt(salaryField.getText());
                        role = Integer.parseInt(roleField.getText());


                        if (Validator.validateEmail(email)){


                            AuthProvider authProvider = new EmployeeAuthProvider(new DatabaseConnector());
                            Employee user = (Employee) authProvider.signupEmployee(username, password, email, fullName, dateOfBirth, gender, salary, role);


                            if (user != null) {
                                // Authentication successful
                                JOptionPane.showMessageDialog(signUpFrame, "Signup successful!\nWelcome, " + user.getFullName(),
                                        "Success", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                // Authentication failed
                                JOptionPane.showMessageDialog(signUpFrame, "Failed to create account!", "Error",
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
        signUpPanel.add(salaryLabel);
        signUpPanel.add(salaryField);
        signUpPanel.add(roleLabel);
        signUpPanel.add(roleField);
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


    public void showSignupEmployeeForm() {
        signUpFrame.setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUpfFormEmployee();
            }
        });
    }
}
