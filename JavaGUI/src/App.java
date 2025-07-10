
import java.awt.GridLayout;
import javax.swing.*;

public class App {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Registation Form");

        JLabel fullNameLabel = new JLabel("FullName:");
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JLabel confirmLabel = new JLabel("Comfirm:");

        JTextField fullnameField = new JTextField(15);
        JTextField userField = new JTextField(15);
        JPasswordField passField = new JPasswordField(15);
        JPasswordField confirmField = new JPasswordField(15);
        JButton loginButton = new JButton("Submit");

        loginButton.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            String fullname = fullnameField.getText();
            String confirm = new String(confirmField.getPassword());

            if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Sorry is invalid");

            } else {
                if (user.equals("tola") && pass.equals("123") && (fullname.equals("tola ouen")) && confirm.equals("123")) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                }
            }
        });

        frame.add(fullNameLabel);
        frame.add(fullnameField);
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(confirmLabel);
        frame.add(confirmField);
        frame.add(new JLabel());
        frame.add(loginButton);

        frame.setLayout(new GridLayout(5, 2));
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
