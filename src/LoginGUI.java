import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel resultLabel;

    // Inject your existing UserService
    private UserService userService;

    public LoginGUI(UserService userService) {
        this.userService = userService;

        frame = new JFrame("Ad Platform - Login");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        frame.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        frame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        frame.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 90, 80, 25);
        frame.add(loginButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(100, 90, 200, 25);
        frame.add(resultLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                User user = userService.login(username, password);
                if (user != null) {
                    resultLabel.setText("Login successful");
                    frame.dispose();
                    if (user instanceof Advertiser) {
                        new AdvertiserController().menu((Advertiser) user); // fallback to text-based
                    } else if (user instanceof Publisher) {
                        new PublisherController().menu((Publisher) user); // fallback to text-based
                    }
                } else {
                    resultLabel.setText("Invalid credentials");
                }
            }
        });

        frame.setVisible(true);
    }
}
