
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);
    static List<EmployeeInfo> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        login();
        int option;
        do {
            main_menu();
            System.out.print("Choice your option (0-6): ");
            option = input.nextInt();
            input.nextLine(); // consume newline
            switch (option) {
                case 1 ->
                    add_employee();
                case 2 ->
                    view_employee();
                case 3 ->
                    update_employee();
                case 4 ->
                    delete_employee();
                case 5 ->
                    find_employee_salaries();
                case 6 ->
                    sort_employee_by_id();
                case 0 ->
                    System.out.println("Exiting program Succesful..!");
                default ->
                    System.out.println("Invalid option! Try again.");
            }
        } while (option != 0);
    }

    public static void main_menu() {
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Find Employee Salary Lower");
        System.out.println("6. Sort Employee By ID");
        System.out.println("0. Exit Program");

    }

    public static void login() {
        String username, password;
        while (true) {
            System.out.print("Enter username: ");
            username = input.nextLine();
            System.out.print("Enter password: ");
            password = input.nextLine();
            if (username.equals("dara") && password.equals("123")) {
                System.out.println("Welcome to Employee Manager System\n");
                break;
            } else {
                System.out.println("Your info is not correct. Please input again.\n");
            }
        }
    }

    public static void add_employee() {
        char choice;
        do {
            System.out.println("Welcome To Add Employee");
            System.out.print("Enter Id: ");
            int id = input.nextInt();
            input.nextLine();
            System.out.print("Enter name: ");
            String name = input.nextLine();
            System.out.print("Enter salary: ");
            double salary = input.nextDouble();
            input.nextLine();

            employeeList.add(new EmployeeInfo(id, name, salary));
            System.out.println("Do you want to input another (N/Y): ");
            choice = input.nextLine().toUpperCase().charAt(0);
            input.nextLine();

        } while (choice == 'Y');
    }

    public static void view_employee() {
        for (EmployeeInfo e : employeeList) {
            System.out.println(e);
        }
    }

    public static void update_employee() {
        System.out.print("Enter Employee Id to update: ");
        int id = input.nextInt();
        for (EmployeeInfo e : employeeList) {
            if (e.id == id) {
                System.out.print("Enter New name: ");
                e.name = input.nextLine();
                System.out.print("Enter New Salary: ");
                e.Salary = input.nextDouble();
                input.nextLine();
                System.out.println("Update succesfull");
                return;
            }
        }
        System.out.println("Not found Id");
    }

    public static void delete_employee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = input.nextInt();
        input.nextLine();
        Iterator<EmployeeInfo> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            EmployeeInfo e = iterator.next();
            if (e.id == id) {
                iterator.remove();
                System.out.println("Employee deleted.");
                return;
            }
        }
    }

    public static void find_employee_salaries() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to evaluate.");
            return;
        }
        EmployeeInfo highest = Collections.max(employeeList, Comparator.comparingDouble(e -> e.Salary));
        EmployeeInfo lowest = Collections.min(employeeList, Comparator.comparingDouble(e -> e.Salary));
        System.out.println("Highest Salary: " + highest);
        System.out.println("Lowest Salary: " + lowest);
    }

    public static void sort_employee_by_id() {
        employeeList.sort(Comparator.comparingInt(e -> e.id));
        System.out.println("Employees sorted by ID:");
        view_employee();
    }

}
