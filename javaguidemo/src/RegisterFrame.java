import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterFrame extends JFrame {
    private JTextField emailField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton createBtn = new JButton("Create Account");

    public RegisterFrame() {
        setTitle("Register");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 180);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        add(createBtn, gbc);

        createBtn.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            if (!email.isEmpty() && !password.isEmpty()) {
                UserDatabase.register(email, password);
                JOptionPane.showMessageDialog(this, "Registered!");
                new LoginFrame().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Fields required");
            }
        });
    }
}

