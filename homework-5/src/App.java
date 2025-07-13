
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            boolean test = true;
            int number;
            while (test) {
                System.out.println("\n1. Manager Annaul Pay");
                System.out.println("2. Staff Annaul Pay");
                System.out.println("3. Full Time Annaul Pay");
                System.out.println("4. Part Time Annaul Pay");
                System.out.println("0. Exit");

                System.out.print("\nEnter choice: ");
                number = input.nextInt();

                switch (number) {
                    case 1 -> {
                        System.out.print("\nEnter Name: ");
                        String name = input.next();
                        System.out.print("Enter Hiring Year: ");
                        int year = input.nextInt();
                        System.out.print("Enter salary: ");
                        int salary = input.nextInt();
                        Manager manager = new Manager(name, year, salary);
                        System.out.println("\nManager Annaul Pay = $" + manager.annaulPay());
                    }
                    case 2 -> {
                        System.out.print("\nEnter Name: ");
                        String name = input.next();
                        System.out.print("Enter Hiring Year: ");
                        int year = input.nextInt();
                        System.out.print("Enter salary: ");
                        int salary = input.nextInt();
                        Staff staff = new Staff(name, year, salary);
                        System.out.println("\nStaff Annaul Pay = $" + staff.annaulPay());
                    }

                    case 3 -> {
                        System.out.print("\nEnter Name: ");
                        String name = input.next();
                        System.out.print("Enter Hiring Year: ");
                        int year = input.nextInt();
                        System.out.print("Enter Hours Per Week: ");
                        int hoursPerWeek = input.nextInt();
                        System.out.print("Enter Hourly Wage: ");
                        double hourlyWage = input.nextDouble();
                        FullTime fulltime = new FullTime(name, year, hoursPerWeek, hourlyWage);
                        System.out.println("\nFull Time Annaul Pay = $" + fulltime.annaulPay());
                    }
                    case 4 -> {
                        System.out.print("\nEnter Name: ");
                        String name = input.next();
                        System.out.print("Enter Hiring Year: ");
                        int year = input.nextInt();
                        System.out.print("Enter Hours Per Week: ");
                        int hoursPerWeek = input.nextInt();
                        System.out.print("Enter Hourly Wage: ");
                        double hourlyWage = input.nextDouble();
                        PartTime partime = new PartTime(name, year, hoursPerWeek, hourlyWage);
                        System.out.println("\nPart Time Annaul Pay = $" + partime.annaulPay());
                    }
                    case 0 -> {
                        System.out.println("\nExit succesfully");
                        System.exit(0);
                        break;
                    }

                    default -> {
                        System.out.println("\nSorry invalid choice. Please Trye Again");
                    }
                }

            }
        }

    }
}
