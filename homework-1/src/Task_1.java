
import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        int num_1, num_2;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Input number 1: ");
            num_1 = input.nextInt();
            System.out.print("Input number 2: ");
            num_2 = input.nextInt();
        }
        System.out.println("Sum of two integer = " + (num_1 + num_2));
        System.out.println("Product of two integer = " + (num_1 * num_2));
        System.out.println("Average of two integer = " + ((float) num_1 + num_2) / 2);
        if (num_1 >= num_2) {
            System.out.println("Max integer = " + num_1);
            if (num_2 <= num_1) {
                System.out.println("Min integer = " + num_2);
            }
        }
    }
}
