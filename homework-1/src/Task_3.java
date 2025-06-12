
import java.util.Scanner;

public class Task_3 {

    public static void main(String[] args) {
        int number;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Input number: ");
            number = input.nextInt();
            if (number % 2 == 0) {
                System.out.println(number + " is even number");
            } else {
                System.out.println(number + " is odd number");
            }
        } catch (Exception e) {
            System.out.println("Error  Occur invalid input");
        }
    }
}
