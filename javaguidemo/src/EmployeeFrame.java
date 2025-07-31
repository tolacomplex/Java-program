import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeFrame extends JFrame {
    private JTextField nameField = new JTextField(10);
    private JTextField ageField = new JTextField(5);
    private JTextField roleField = new JTextField(10);

    private JButton addButton = new JButton("Add");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");

    private DefaultTableModel tableModel;
    private JTable table;

    public EmployeeFrame() {
        setTitle("Employee Manager");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Define table model with columns
        tableModel = new DefaultTableModel(new Object[]{"Name", "Age", "Role"}, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Role:"));
        inputPanel.add(roleField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Button actions
        addButton.addActionListener(e -> addEmployee());
        updateButton.addActionListener(e -> updateEmployee());
        deleteButton.addActionListener(e -> deleteEmployee());

        // Load dummy data (optional)
        tableModel.addRow(new Object[]{"John Doe", 30, "Developer"});
        tableModel.addRow(new Object[]{"Jane Smith", 28, "Designer"});
    }

    private void addEmployee() {
        String name = nameField.getText();
        String age = ageField.getText();
        String role = roleField.getText();

        if (name.isEmpty() || age.isEmpty() || role.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        try {
            int ageVal = Integer.parseInt(age);
            tableModel.addRow(new Object[]{name, ageVal, role});
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Age must be a number");
        }
    }

    private void updateEmployee() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a row to update");
            return;
        }

        String name = nameField.getText();
        String age = ageField.getText();
        String role = roleField.getText();

        if (name.isEmpty() || age.isEmpty() || role.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        try {
            int ageVal = Integer.parseInt(age);
            tableModel.setValueAt(name, selectedRow, 0);
            tableModel.setValueAt(ageVal, selectedRow, 1);
            tableModel.setValueAt(role, selectedRow, 2);
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Age must be a number");
        }
    }

    private void deleteEmployee() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to delete");
        }
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        roleField.setText("");
    }
}
