package pages.admin;

import pages.admin.addMenu.Menu;
import pages.admin.addRoom.AddRoom;
import pages.auth.LoginFormEmployee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainPage {
    private JFrame loginFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public AdminMainPage() {
        loginFrame = new JFrame("Admin Main Page");
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

        JPanel loginPanel = new JPanel(new GridLayout(5, 1, 10, 30));
        loginPanel.setBackground(new Color(155, 89, 182));



        JButton editRoomButton = new JButton("Edit Room");
        editRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                AddRoom addRoom =  new AddRoom();
                addRoom.setVisible(true);
            }
        });

        JButton editMenuButton = new JButton("Edit Menu");

        editMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                Menu menu =  new Menu();
                menu.setVisible(true);
            }
        });

        JButton logoutButton = new JButton("Logout");

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                LoginFormEmployee loginFormEmployee = new LoginFormEmployee();
                loginFormEmployee.showLoginForm();
            }
        });

        JLabel mainLabel = new JLabel("Admin Menu");
        mainLabel.setForeground(Color.white);
        mainLabel.setFont(new Font("High Tower Text", Font.BOLD, 40));


        loginPanel.add(mainLabel);
        loginPanel.add(editRoomButton);
        loginPanel.add(editMenuButton); // Empty label for spacing
        loginPanel.add(logoutButton);


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
                AdminMainPage loginFormGuest = new AdminMainPage();
                loginFormGuest.showLoginForm();
            }
        });
    }
}