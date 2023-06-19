package pages.guest;

import config.DatabaseConnector;
import pages.auth.*;
import pages.guest.bookRoom.RoomFeature;
import pages.guest.orderFood.OrderFood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestMainPage {
    private JFrame loginFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    public static Guest guests;

    public GuestMainPage() {


        loginFrame = new JFrame("Guest Main Page");
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

        JPanel loginPanel = new JPanel(new GridLayout(3, 1, 10, 30));
        loginPanel.setBackground(new Color(155, 89, 182));



        JButton orderRoomButton = new JButton("Order Room");
        JButton orderMenuButton = new JButton("Order Menu");
        orderMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                OrderFood orderFood = new OrderFood();
                orderFood.setVisible(true);
            }
        });

        orderRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                RoomFeature roomFeature = new RoomFeature();
                roomFeature.showRoomCard();
            }
        });


        JLabel mainLabel = new JLabel("Guest Menu");
        mainLabel.setForeground(Color.white);
        mainLabel.setFont(new Font("High Tower Text", Font.BOLD, 40));


        loginPanel.add(mainLabel);
        loginPanel.add(orderRoomButton);
        loginPanel.add(orderMenuButton); // Empty label for spacing


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
                GuestMainPage loginFormGuest = new GuestMainPage();
                loginFormGuest.showLoginForm();
            }
        });
    }
}