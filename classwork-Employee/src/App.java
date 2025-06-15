
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu Employee");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Sort Employee");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    p.showEmployee("Add Employee");
                    int number = p.getEmployee("Enter number: ");
                    p.addEmployee(number);
                    break;
                case 2:
                    p.showEmployee("View Employee");
                    p.showEmployee();
                    break;
                case 3:
                    p.showEmployee("Update Employee");
                    int uNumber = p.getEmployee("Enter Employee number to update: ");
                    p.updateEmployee(uNumber);
                    break;
                case 4:
                    p.showEmployee("Delete Employee");
                    int dNumber = p.getEmployee("Enter Number to delete: ");
                    p.deleteEmployee(dNumber);

                    break;
                case 5:
                    p.showEmployee("Search Employee");
                    int target = p.getEmployee("Search a number: ");
                    p.searchEmployee(target);

                    break;
                case 6:
                    p.sortEmployee();

                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        } while (true);

    }
}
