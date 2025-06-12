
import java.util.Scanner;

public class App {

    //Store
    static final int SIZE = 100;
    static int[] numbers = new int[SIZE];
    static int count = 0;

    static void showNumber(int result) {
        System.out.println("The result is " + result);
    }

    static void showNumber(String msg) {
        System.out.println(msg);
    }

    static void showNumber(String msg, int result) {
        System.out.println(msg + result);
    }

    static int getNumber(String msg) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print(msg);
        number = scanner.nextInt();
        return number;
    }
// function  view number

    static void addNumber(int number) {
        numbers[count++] = number;
    }
// function view  show list number

    static void showNumber() {
        for (int i = 0; i < count; i++) {
            System.out.println("Number: " + numbers[i]);
        }
    }

    // function update number 
    static void updateNumber(int uNumber) {
        Scanner input = new Scanner(System.in);
        int number;
        boolean updated = false;
        for (int i = 0; i < count; i++) {
            if (numbers[i] == uNumber) {
                System.out.print("Enter New number: ");
                numbers[i] = input.nextInt();
                updated = true;

            }
        }
    }

    // function delete number 
    static void deleteNumber(int dNumber) {
        for (int i = 0; i < count; i++) {
            if (numbers[i] == dNumber) {
                for (int j = i; j < count - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                count--;
                break;
            }
        }
    }

    // function search 
    static void searchNumber(int target) {
        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("Found " + target + " at index: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(target + " not found.");
        }
    }

    // function sort number
    static void sortNumber() {
        // Bubble Sort algorithm
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // swap numbers[j] and numbers[j + 1]
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.println("numbers sorted");
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int choice;

        //Input
        do {
            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.println("6. Sort");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            //Process
            switch (choice) {
                case 1:
                    showNumber("Add");
                    int number = getNumber("Enter number: ");
                    addNumber(number);
                    break;
                case 2:
                    showNumber("View");
                    showNumber();
                    break;
                case 3:
                    showNumber("Update");
                    int uNumber = getNumber("Enter number to update: ");
                    updateNumber(uNumber);
                    break;
                case 4:
                    showNumber("Delete");
                    int dNumber = getNumber("Enter Number to delete: ");
                    deleteNumber(dNumber);

                    break;
                case 5:
                    showNumber("Search");
                    int target = getNumber("Search a number: ");
                    searchNumber(target);

                    break;
                case 6:
                    sortNumber();

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
