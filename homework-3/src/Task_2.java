
import java.util.Scanner;

public class Task_2 {

    static String name = "Tola";
    static String AccountNumber = "12345678";
    static double balance;
    static int pin = 1234;

    // New acoount of user
    static String name_2 = "Hong";
    static String AccountNumber_2 = "09887664";
    static double balance_2;
    static int pin_2;

    static double getMessage(String msg) {
        Scanner input = new Scanner(System.in);
        double number;
        System.out.print(msg);
        number = input.nextDouble();
        return number;
    }

    static void authorizePin(int pin1) {
        if (pin == pin1) {
            System.out.println("Welcome " + name);
        } else {
            System.out.println("Sorry..!. Please try again");
        }
    }

    static void deposite(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposite Succesfull. New balance: $" + amount);
        } else {
            System.out.println("Sorry...!. Please try deposite again.");
        }
    }

    static void withDrawal(double amount) {
        if ((amount > 0) & (amount <= balance)) {
            balance -= amount;
            System.out.println("Withdrawal succesfull. Remainding balance: $" + balance);
        } else {
            System.out.println("Sorry...!. Please try withdrawal again.");
        }
    }

    static void transfer(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            balance += amount;
            System.out.println("Transfer succesfull.");
            System.out.println(name + "new balance: $" + balance);
            System.out.println(name_2 + "new balance: $" + balance_2);
        } else {
            System.out.println("Sorry...!. Please transfer again.");
        }
    }

    static void viewProfile(String name, String id) {
        System.out.println("Hello, " + name);
        System.out.println("Account ID: " + id);
        System.out.println("\nBalance: " + balance);
    }

    // Check current balance 
    static void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    static void changePin(int oldPin, int newPin) {
        if (pin == oldPin) {
            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect current PIN.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount;
        int newPin, oldPin;
        do {
            System.out.println("Hello, " + name);
            System.out.println("1. Deposite");
            System.out.println("2. Withdrawal");
            System.out.println("3. Transfer");
            System.out.println("4. Check balance");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit ");
            System.out.print("\nChoice Option: ");
            int number_1 = scanner.nextInt();
            switch (number_1) {
                case 1 -> {
                    System.out.print("Enter PIN: ");
                    int pin1 = scanner.nextInt();
                    authorizePin(pin1);
                    amount = getMessage("Deposite amound: ");
                    deposite(amount);
                    break;
                }
                case 2 -> {
                    System.out.print("Enter PIN: ");
                    int pin1 = scanner.nextInt();
                    authorizePin(pin1);
                    amount = getMessage("Withdrawal amount: ");
                    withDrawal(amount);
                    break;
                }
                case 3 -> {
                    System.out.print("Enter PIN: ");
                    int pin1 = scanner.nextInt();
                    authorizePin(pin1);
                    amount = getMessage("Transfer amount: ");
                    transfer(amount);
                    break;
                }
                case 4 -> {
                    System.out.print("Enter PIN: ");
                    int pin1 = scanner.nextInt();
                    authorizePin(pin1);
                    viewProfile(name, AccountNumber);
                    checkBalance();
                    break;
                }

                case 5 -> {
                    System.out.print("Enter Old PIN: ");
                    oldPin = scanner.nextInt();
                    System.out.print("Enter New PIN: ");
                    newPin = scanner.nextInt();
                    changePin(oldPin, newPin);
                    break;
                }
                case 6 -> {
                    System.exit(0);
                    System.out.println("Exit Succesfully");
                    break;
                }
                default -> {
                    System.out.println("Invalid");
                }

            }
        } while (true);
    }
}
