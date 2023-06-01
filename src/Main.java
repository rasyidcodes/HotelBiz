

import pages.auth.LoginFormGuest;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main extends JFrame {
    private static final int SPLASH_SCREEN_DURATION = 3000;
    public static void main(String[] args) {
        showSplashScreen();

        // Perform any initialization or loading tasks here...
        // Simulating a task by sleeping for a few seconds
        try {
            Thread.sleep(SPLASH_SCREEN_DURATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hideSplashScreen();

        // Proceed with the rest of your application
        SwingUtilities.invokeLater(() -> {
            LoginFormGuest loginForm = new LoginFormGuest();
            loginForm.showLoginForm();
        });
    }

    private static void showSplashScreen() {
        JFrame splashFrame = new JFrame();
        splashFrame.setUndecorated(true);

        // Set the size and position of the splash screen
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int splashWidth = 400;
        int splashHeight = 300;
        int x = (screenWidth - splashWidth) / 2;
        int y = (screenHeight - splashHeight) / 2;
        splashFrame.setBounds(x, y, splashWidth, splashHeight);

        // Create a JLabel with an image for the splash screen
        URL imageURL =  Main.class.getResource("/src/logo_splash.png");
        ImageIcon splashImageIcon = new ImageIcon(imageURL);
        JLabel splashLabel = new JLabel(splashImageIcon);

        splashFrame.getContentPane().add(splashLabel);
        splashFrame.setVisible(true);
    }

    private static void hideSplashScreen() {
        for (Window window : Window.getWindows()) {
            if (window.isShowing() && window instanceof JFrame) {
                window.dispose();
            }
        }
    }
}
