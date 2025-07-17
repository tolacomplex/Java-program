
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Employee {

    private int id;
    private String name;
    private String position;

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

public class EmployeeManagementApp extends JFrame {

    private ArrayList<Employee> employees = new ArrayList<>();

    private JTextField idField = new JTextField(10);
    private JTextField nameField = new JTextField(10);
    private JTextField positionField = new JTextField(10);
    private JTextField searchField = new JTextField(15);

    private JTable employeeTable;
    private DefaultTableModel tableModel;

    public EmployeeManagementApp() {
        super("Employee Management System");

        // Setup table columns
        String[] columns = {"ID", "Name", "Position"};
        tableModel = new DefaultTableModel(columns, 0);
        employeeTable = new JTable(tableModel);
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Layout components
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Employee Details"));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Position:"));
        inputPanel.add(positionField);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        inputPanel.add(addBtn);
        inputPanel.add(updateBtn);

        JPanel deletePanel = new JPanel();
        deletePanel.add(deleteBtn);

        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search"));
        searchPanel.add(new JLabel("Search by ID or Name:"));
        searchPanel.add(searchField);
        JButton searchBtn = new JButton("Search");
        JButton showAllBtn = new JButton("Show All");
        searchPanel.add(searchBtn);
        searchPanel.add(showAllBtn);

        JPanel sortPanel = new JPanel();
        sortPanel.setBorder(BorderFactory.createTitledBorder("Sort"));
        JButton sortByIdBtn = new JButton("Sort by ID");
        JButton sortByNameBtn = new JButton("Sort by Name");
        sortPanel.add(sortByIdBtn);
        sortPanel.add(sortByNameBtn);

        // Add components to frame
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(employeeTable), BorderLayout.CENTER);
        add(deletePanel, BorderLayout.EAST);
        add(searchPanel, BorderLayout.SOUTH);
        add(sortPanel, BorderLayout.WEST);

        // Button actions
        addBtn.addActionListener(e -> addEmployee());
        updateBtn.addActionListener(e -> updateEmployee());
        deleteBtn.addActionListener(e -> deleteEmployee());
        searchBtn.addActionListener(e -> searchEmployees());
        showAllBtn.addActionListener(e -> refreshTable());
        sortByIdBtn.addActionListener(e -> {
            employees.sort(Comparator.comparingInt(Employee::getId));
            refreshTable();
        });
        sortByNameBtn.addActionListener(e -> {
            employees.sort(Comparator.comparing(Employee::getName));
            refreshTable();
        });

        // Select employee in table and load data into fields
        employeeTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && employeeTable.getSelectedRow() != -1) {
                int row = employeeTable.getSelectedRow();
                idField.setText(tableModel.getValueAt(row, 0).toString());
                nameField.setText(tableModel.getValueAt(row, 1).toString());
                positionField.setText(tableModel.getValueAt(row, 2).toString());
                idField.setEnabled(false); // ID should not be changed on update
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addEmployee() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            String position = positionField.getText().trim();

            if (name.isEmpty() || position.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name and Position cannot be empty.");
                return;
            }

            // Check duplicate ID
            for (Employee e : employees) {
                if (e.getId() == id) {
                    JOptionPane.showMessageDialog(this, "Employee ID already exists.");
                    return;
                }
            }

            employees.add(new Employee(id, name, position));
            refreshTable();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID. Enter a valid integer.");
        }
    }

    private void updateEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select an employee to update.");
            return;
        }
        try {
            String name = nameField.getText().trim();
            String position = positionField.getText().trim();

            if (name.isEmpty() || position.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name and Position cannot be empty.");
                return;
            }

            int id = Integer.parseInt(idField.getText());

            // Find employee and update
            for (Employee e : employees) {
                if (e.getId() == id) {
                    e.setName(name);
                    e.setPosition(position);
                    break;
                }
            }
            refreshTable();
            clearFields();
            idField.setEnabled(true);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID.");
        }
    }

    private void deleteEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select an employee to delete.");
            return;
        }
        int id = (int) tableModel.getValueAt(selectedRow, 0);
        employees.removeIf(e -> e.getId() == id);
        refreshTable();
        clearFields();
        idField.setEnabled(true);
    }

    private void searchEmployees() {
        String keyword = searchField.getText().trim().toLowerCase();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter search keyword.");
            return;
        }
        DefaultTableModel searchModel = new DefaultTableModel(new String[]{"ID", "Name", "Position"}, 0);
        for (Employee e : employees) {
            if (String.valueOf(e.getId()).contains(keyword) || e.getName().toLowerCase().contains(keyword)) {
                searchModel.addRow(new Object[]{e.getId(), e.getName(), e.getPosition()});
            }
        }
        employeeTable.setModel(searchModel);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getName(), e.getPosition()});
        }
        employeeTable.setModel(tableModel);
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        positionField.setText("");
        searchField.setText("");
        idField.setEnabled(true);
        employeeTable.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmployeeManagementApp::new);
    }
}
