
import java.util.Scanner;

public class Person {

    public final int SIZE = 100;
    public int[] numbers = new int[SIZE];
    public int count = 0;

    public void showEmployee(int result) {
        System.out.println("The result is " + result);
    }

    public void showEmployee(String msg) {
        System.out.println(msg);
    }

    public void showEmployee(String msg, int result) {
        System.out.println(msg + result);
    }

    public int getEmployee(String msg) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number;
            System.out.print(msg);
            number = scanner.nextInt();
            return number;
        }
    }

    // Mothod add employee
    public void addEmployee(int number) {
        numbers[count++] = number;
    }
// Show View employee

    public void showEmployee() {
        for (int i = 0; i < count; i++) {
            System.out.println("Number: " + numbers[i]);
        }
    }
// Method update infomation

    public void updateEmployee(int uNumber) {
        try (Scanner input = new Scanner(System.in)) {
            for (int i = 0; i < count; i++) {
                if (numbers[i] == uNumber) {
                    System.out.print("Enter New number: ");
                    numbers[i] = input.nextInt();

                }
            }
        }
    }

    // Methon delete employee
    public void deleteEmployee(int dNumber) {
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

    // Method search 
    public void searchEmployee(int target) {
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

    // Method sort
    public void sortEmployee() {
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
}
