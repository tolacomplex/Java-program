
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BillingSystem extends JFrame {

    private JTextField customerNameField, itemNameField, quantityField, priceField, searchField;
    private JTable billTable;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> tableSorter;
    private JLabel totalLabel;
    private JTextArea billDisplay;
    private ArrayList<BillItem> billItems;
    private double grandTotal = 0.0;
    private String currentUser = "";

    // User credentials (In real application, this would be in a database)
    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", "admin123");
        users.put("cashier", "cash123");
        users.put("manager", "mgr123");
        users.put("user", "user123");
    }

    // Login Panel Class
    static class LoginPanel extends JFrame {

        private JTextField usernameField;
        private JPasswordField passwordField;
        private JButton loginButton, exitButton;
        private JLabel statusLabel;

        public LoginPanel() {
            setTitle("Billing System - Login");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 600);
            setLocationRelativeTo(null);
            setResizable(false);

            initializeLoginComponents();
            setupLoginLayout();
        }

        private void initializeLoginComponents() {
            usernameField = new JTextField(15);
            passwordField = new JPasswordField(15);

            loginButton = new JButton("Login");
            loginButton.setBackground(new Color(34, 139, 34));
            loginButton.setForeground(Color.BLACK);
            loginButton.setFont(new Font("Arial", Font.BOLD, 14));

            exitButton = new JButton("Exit");
            exitButton.setBackground(new Color(220, 20, 60));
            exitButton.setForeground(Color.BLACK);
            exitButton.setFont(new Font("Arial", Font.BOLD, 14));

            statusLabel = new JLabel("");
            statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }

        private void setupLoginLayout() {
            setLayout(new BorderLayout());

            // Title Panel
            JPanel titlePanel = new JPanel();
            titlePanel.setBackground(new Color(70, 130, 180));
            JLabel titleLabel = new JLabel("BILLING SYSTEM");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            titleLabel.setForeground(Color.WHITE);
            titlePanel.add(titleLabel);

            // Main Panel
            JPanel mainPanel = new JPanel(new GridBagLayout());
            mainPanel.setBackground(Color.WHITE);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);

            // Username
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            JLabel userLabel = new JLabel("Username:");
            userLabel.setFont(new Font("Arial", Font.BOLD, 14));
            mainPanel.add(userLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            mainPanel.add(usernameField, gbc);

            // Password
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.EAST;
            JLabel passLabel = new JLabel("Password:");
            passLabel.setFont(new Font("Arial", Font.BOLD, 14));
            mainPanel.add(passLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.WEST;
            mainPanel.add(passwordField, gbc);

            // Buttons
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.setBackground(Color.WHITE);
            buttonPanel.add(loginButton);
            buttonPanel.add(exitButton);
            mainPanel.add(buttonPanel, gbc);

            // Status Label
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            mainPanel.add(statusLabel, gbc);

            // Credentials Info Panel
            JPanel infoPanel = new JPanel();
            infoPanel.setBackground(new Color(240, 248, 255));

            add(titlePanel, BorderLayout.NORTH);
            add(mainPanel, BorderLayout.CENTER);
            add(infoPanel, BorderLayout.SOUTH);

            // Event listeners
            loginButton.addActionListener(e -> performLogin());
            exitButton.addActionListener(e -> System.exit(0));

            // Enter key support
            usernameField.addActionListener(e -> performLogin());
            passwordField.addActionListener(e -> performLogin());

            // Focus
            usernameField.requestFocus();
        }

        private void performLogin() {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                showStatus("Please enter username and password!", Color.RED);
                return;
            }

            if (users.containsKey(username) && users.get(username).equals(password)) {
                showStatus("Login successful! Opening billing system...", new Color(0, 150, 0));

                // Delay to show success message
                Timer timer = new Timer(1000, e -> {
                    this.dispose();
                    SwingUtilities.invokeLater(() -> {
                        new BillingSystem(username).setVisible(true);
                    });
                });
                timer.setRepeats(false);
                timer.start();

            } else {
                showStatus("Invalid username or password!", Color.RED);
                passwordField.setText("");
                usernameField.requestFocus();
            }
        }

        private void showStatus(String message, Color color) {
            statusLabel.setText(message);
            statusLabel.setForeground(color);
        }
    }

    public BillingSystem(String username) {
        this.currentUser = username;
        setTitle("Billing System - Welcome " + username);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1500, 800);

        billItems = new ArrayList<>();
        initializeComponents();
        setupLayout();
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        // Input fields
        customerNameField = new JTextField(20);
        itemNameField = new JTextField(15);
        quantityField = new JTextField(5);
        priceField = new JTextField(10);
        searchField = new JTextField(15);

        // Table for bill items
        String[] columns = {"Item Name", "Quantity", "Unit Price", "Total Price"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        billTable = new JTable(tableModel);
        billTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add table sorter
        tableSorter = new TableRowSorter<>(tableModel);
        billTable.setRowSorter(tableSorter);

        // Total label
        totalLabel = new JLabel("Grand Total: $0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setForeground(Color.BLUE);

        // Bill display area
        billDisplay = new JTextArea(15, 30);
        billDisplay.setEditable(false);
        billDisplay.setFont(new Font("Courier New", Font.PLAIN, 12));
        billDisplay.setBackground(Color.WHITE);
    }

    private void setupLayout() {
        // Top panel for customer info and user info
        JPanel topPanel = new JPanel(new BorderLayout());

        JPanel customerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer Information"));
        customerPanel.add(new JLabel("Customer Name:"));
        customerPanel.add(customerNameField);

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel userLabel = new JLabel("Logged in as: " + currentUser);
        userLabel.setFont(new Font("Arial", Font.BOLD, 12));
        userLabel.setForeground(new Color(0, 100, 0));
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(220, 20, 60));
        logoutButton.setForeground(Color.BLACK);
        logoutButton.addActionListener(e -> logout());

        userPanel.add(userLabel);
        userPanel.add(logoutButton);

        topPanel.add(customerPanel, BorderLayout.CENTER);
        topPanel.add(userPanel, BorderLayout.EAST);

        // Input panel for items
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Items"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Item Name:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(itemNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(quantityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Unit Price:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(priceField, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Item");
        JButton removeButton = new JButton("Delete Item");
        JButton clearButton = new JButton("Clear All");
        JButton generateBillButton = new JButton("Generate Bill");

        addButton.setBackground(new Color(34, 139, 34));
        addButton.setForeground(Color.BLACK);
        removeButton.setBackground(new Color(220, 20, 60));
        removeButton.setForeground(Color.BLACK);
        clearButton.setBackground(new Color(255, 140, 0));
        clearButton.setForeground(Color.BLACK);
        generateBillButton.setBackground(new Color(70, 130, 180));
        generateBillButton.setForeground(Color.BLACK);

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(generateBillButton);

        // Search and Sort Panel
        JPanel searchSortPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchSortPanel.setBorder(BorderFactory.createTitledBorder("Search & Sort"));

        searchSortPanel.add(new JLabel("Search:"));
        searchSortPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        JButton clearSearchButton = new JButton("Clear Search");
        searchButton.setBackground(new Color(128, 0, 128));
        searchButton.setForeground(Color.BLACK);
        clearSearchButton.setBackground(new Color(105, 105, 105));
        clearSearchButton.setForeground(Color.BLACK);

        searchSortPanel.add(searchButton);
        searchSortPanel.add(clearSearchButton);

        // Sort buttons
        JButton sortByNameButton = new JButton("Sort by Name");
        JButton sortByQuantityButton = new JButton("Sort by Quantity");
        JButton sortByPriceButton = new JButton("Sort by Price");
        JButton sortByTotalButton = new JButton("Sort by Total");

        sortByNameButton.setBackground(new Color(75, 0, 130));
        sortByNameButton.setForeground(Color.BLACK);
        sortByQuantityButton.setBackground(new Color(75, 0, 130));
        sortByQuantityButton.setForeground(Color.BLACK);
        sortByPriceButton.setBackground(new Color(75, 0, 130));
        sortByPriceButton.setForeground(Color.BLACK);
        sortByTotalButton.setBackground(new Color(75, 0, 130));
        sortByTotalButton.setForeground(Color.BLACK);

        searchSortPanel.add(new JLabel(" | Sort:"));
        searchSortPanel.add(sortByNameButton);
        searchSortPanel.add(sortByQuantityButton);
        searchSortPanel.add(sortByPriceButton);
        searchSortPanel.add(sortByTotalButton);

        // Left panel combining input and buttons
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(inputPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Center panel for table with search/sort controls
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Bill Items"));
        centerPanel.add(searchSortPanel, BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(billTable), BorderLayout.CENTER);
        centerPanel.add(totalLabel, BorderLayout.SOUTH);

        // Right panel for bill display
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Generated Bill"));
        rightPanel.add(new JScrollPane(billDisplay), BorderLayout.CENTER);

        // Main layout
        add(topPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        // Event listeners
        addButton.addActionListener(e -> addItem());
        removeButton.addActionListener(e -> removeItem());
        clearButton.addActionListener(e -> clearAll());
        generateBillButton.addActionListener(e -> generateBill());

        // Search and Sort event listeners
        searchButton.addActionListener(e -> performSearch());
        clearSearchButton.addActionListener(e -> clearSearch());
        sortByNameButton.addActionListener(e -> sortByColumn(0, "name"));
        sortByQuantityButton.addActionListener(e -> sortByColumn(1, "quantity"));
        sortByPriceButton.addActionListener(e -> sortByColumn(2, "price"));
        sortByTotalButton.addActionListener(e -> sortByColumn(3, "total"));

        // Enter key support
        itemNameField.addActionListener(e -> addItem());
        quantityField.addActionListener(e -> addItem());
        priceField.addActionListener(e -> addItem());
        searchField.addActionListener(e -> performSearch());
    }

    private void addItem() {
        try {
            String itemName = itemNameField.getText().trim();
            String quantityText = quantityField.getText().trim();
            String priceText = priceField.getText().trim();

            if (itemName.isEmpty() || quantityText.isEmpty() || priceText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantity = Integer.parseInt(quantityText);
            double unitPrice = Double.parseDouble(priceText);

            if (quantity <= 0 || unitPrice < 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be positive and price cannot be negative!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double totalPrice = quantity * unitPrice;
            BillItem item = new BillItem(itemName, quantity, unitPrice, totalPrice);
            billItems.add(item);

            // Add to table
            Object[] row = {itemName, quantity, String.format("$%.2f", unitPrice), String.format("$%.2f", totalPrice)};
            tableModel.addRow(row);

            // Update grand total
            grandTotal += totalPrice;
            totalLabel.setText(String.format("Grand Total: $%.2f", grandTotal));

            // Clear input fields
            itemNameField.setText("");
            quantityField.setText("");
            priceField.setText("");
            itemNameField.requestFocus();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for quantity and price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeItem() {
        int selectedRow = billTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to remove!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convert view row to model row (important when table is sorted/filtered)
        int modelRow = billTable.convertRowIndexToModel(selectedRow);

        // Update grand total
        BillItem item = billItems.get(modelRow);
        grandTotal -= item.getTotalPrice();
        totalLabel.setText(String.format("Grand Total: $%.2f", grandTotal));

        // Remove from list and table
        billItems.remove(modelRow);
        tableModel.removeRow(modelRow);
    }

    private void clearAll() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to clear all items?", "Confirm Clear", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            billItems.clear();
            tableModel.setRowCount(0);
            grandTotal = 0.0;
            totalLabel.setText("Grand Total: $0.00");
            customerNameField.setText("");
            billDisplay.setText("");
            searchField.setText("");
            clearSearch();
            itemNameField.requestFocus();
        }
    }

    private void generateBill() {
        if (billItems.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No items to generate bill!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String customerName = customerNameField.getText().trim();
        if (customerName.isEmpty()) {
            customerName = "Walk-in Customer";
        }

        StringBuilder bill = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDate = sdf.format(new Date());

        bill.append("=====================================\n");
        bill.append("           INVOICE\n");
        bill.append("=====================================\n");
        bill.append("Date: ").append(currentDate).append("\n");
        bill.append("Customer: ").append(customerName).append("\n");
        bill.append("=====================================\n");
        bill.append(String.format("%-20s %3s %8s %10s\n", "Item", "Qty", "Price", "Total"));
        bill.append("-------------------------------------\n");

        for (BillItem item : billItems) {
            bill.append(String.format("%-20s %3d $%7.2f $%9.2f\n",
                    item.getItemName(),
                    item.getQuantity(),
                    item.getUnitPrice(),
                    item.getTotalPrice()));
        }

        bill.append("-------------------------------------\n");
        bill.append(String.format("%33s $%9.2f\n", "GRAND TOTAL:", grandTotal));
        bill.append("=====================================\n");
        bill.append("        Thank you for your business!\n");
        bill.append("=====================================\n");

        billDisplay.setText(bill.toString());
        JOptionPane.showMessageDialog(this, "Bill generated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Search functionality
    private void performSearch() {
        String searchText = searchField.getText().trim().toLowerCase();
        if (searchText.isEmpty()) {
            clearSearch();
            return;
        }

        RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
                // Search in item name (column 0)
                String itemName = entry.getStringValue(0).toLowerCase();
                return itemName.contains(searchText);
            }
        };

        tableSorter.setRowFilter(filter);
        updateTotalForFilteredItems();
    }

    private void clearSearch() {
        searchField.setText("");
        tableSorter.setRowFilter(null);
        updateTotalLabel();
    }

    // Sort functionality
    private void sortByColumn(int columnIndex, String sortType) {
        Collections.sort(billItems, getComparator(sortType));
        refreshTable();
        JOptionPane.showMessageDialog(this, "Items sorted by " + sortType + "!", "Sort Complete", JOptionPane.INFORMATION_MESSAGE);
    }

    private Comparator<BillItem> getComparator(String sortType) {
        switch (sortType) {
            case "name":
                return Comparator.comparing(BillItem::getItemName, String.CASE_INSENSITIVE_ORDER);
            case "quantity":
                return Comparator.comparing(BillItem::getQuantity);
            case "price":
                return Comparator.comparing(BillItem::getUnitPrice);
            case "total":
                return Comparator.comparing(BillItem::getTotalPrice);
            default:
                return Comparator.comparing(BillItem::getItemName, String.CASE_INSENSITIVE_ORDER);
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (BillItem item : billItems) {
            Object[] row = {
                item.getItemName(),
                item.getQuantity(),
                String.format("$%.2f", item.getUnitPrice()),
                String.format("$%.2f", item.getTotalPrice())
            };
            tableModel.addRow(row);
        }
    }

    private void updateTotalLabel() {
        totalLabel.setText(String.format("Grand Total: $%.2f", grandTotal));
    }

    private void updateTotalForFilteredItems() {
        double filteredTotal = 0.0;
        int rowCount = billTable.getRowCount();

        if (rowCount == 0) {
            totalLabel.setText("Filtered Total: $0.00 | Grand Total: $" + String.format("%.2f", grandTotal));
            return;
        }

        for (int i = 0; i < rowCount; i++) {
            int modelRow = billTable.convertRowIndexToModel(i);
            filteredTotal += billItems.get(modelRow).getTotalPrice();
        }

        totalLabel.setText(String.format("Filtered Total: $%.2f | Grand Total: $%.2f", filteredTotal, grandTotal));
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to logout?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
            SwingUtilities.invokeLater(() -> {
                new LoginPanel().setVisible(true);
            });
        }
    }

    // Inner class for bill items
    private static class BillItem {

        private String itemName;
        private int quantity;
        private double unitPrice;
        private double totalPrice;

        public BillItem(String itemName, int quantity, double unitPrice, double totalPrice) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.totalPrice = totalPrice;
        }

        public String getItemName() {
            return itemName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new LoginPanel().setVisible(true);
        });
    }
}
