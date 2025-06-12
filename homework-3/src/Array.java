
import java.util.Scanner;

public class Array {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //Store
        final int SIZE = 100;
        int[] numbers = new int[SIZE];
        int choice;
        int count = 0;
        //Input
        do {
            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Delete");
            System.out.println("6. Delete");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            //Process
            switch (choice) {
                case 1 -> {
                    System.out.println("Add");
                    System.out.println("Enter number: ");
                    numbers[count++] = scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("View");
                    for (int i = 0; i < count; i++) {
                        System.out.println("Number: " + numbers[i]);
                    }
                }
                case 3 -> {
                    System.out.println("Update");
                    int uNumber;
                    System.out.println("Enter updated number: ");
                    uNumber = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        if (numbers[i] == uNumber) {
                            System.out.println("Enter new number: ");
                            numbers[i] = scanner.nextInt();
                            break;
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Delete");
                    int dNumber;
                    System.out.println("Enter deleted number: ");
                    dNumber = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        if (numbers[i] == dNumber) {
                            for (int j = i; j < count - 1; j++) {
                                numbers[j] = numbers[j + 1];
                            }
                            break;
                        }
                        count--;
                    }
                }
                case 5 -> {
                  System.out.println("Search");
                  int sNumber;
                  System.out.print("Search number: ");
                  sNumber = scanner.nextInt();
                  for (int i = 0; i < count; i++ ) {
                    if (sNumber == numbers[count++]) {
                      System.out.println("Search number: ");
                      
                    }
                  }
                  
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid");
            }
        } while (true);

    }
}
