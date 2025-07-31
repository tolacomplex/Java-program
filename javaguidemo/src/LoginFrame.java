import java.awt.*;
import javax.swing.*;

public class LoginFrame extends JFrame {
    private JTextField emailField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton loginBtn = new JButton("Login");
    private JButton registerBtn = new JButton("Register");

    public LoginFrame() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("អ៊ុីម៉ែល:"), gbc);
        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("លេខសំខាន់:"), gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(loginBtn, gbc);
        gbc.gridx = 1;
        add(registerBtn, gbc);

        loginBtn.addActionListener(e -> login());
        registerBtn.addActionListener(e -> {
            new RegisterFrame().setVisible(true);
            this.dispose();
        });
    }

    private void login() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (UserDatabase.authenticate(email, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            new EmployeeFrame().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials");
        }
    }
}

