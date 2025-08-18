
import java.util.Scanner;

public class Swicth {

    public static void main(String[] args) {
        int month;
        Scanner input = new Scanner(System.in);
        System.out.print("Input month 1 to 12: ");
        month = input.nextInt();
        switch (month) {
            case 2 -> {
                System.out.println("Have a 28 day");
                // break;
            }
            case 4, 6, 9, 11 -> {
                System.out.println("Have a 30 day");
            }
            case 1, 3, 5, 7, 8, 10, 12 -> {
                System.out.println("Have a 31 day");
                // break;
            }
            default -> {
                System.out.println("Invalid month");
                // break;
            }
        }
    }
}
