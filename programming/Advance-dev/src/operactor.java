
import java.util.Scanner;

public class operactor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input number 1: ");
        int num_1 = input.nextInt();
        System.out.print("Input number 2: ");
        int num_2 = input.nextInt();
        System.out.print("Input number 3: ");
        int num_3 = input.nextInt();
        System.out.print("Input operactor(+ - * / %): ");
        String operactor = input.next();

        switch (operactor) {
            case "+" ->
                System.out.println("Num_1 + Num_2 + Num_3 = " + (num_1 + num_2 + num_3));
            case "-" ->
                System.out.println("Num_1 - Num_2 - Num_3 = " + (num_1 - num_2 - num_3));
            case "*" ->
                System.out.println("Num_1 * Num_2 * Num_3 = " + (num_1 * num_2 * num_3));
            case "/" ->
                System.out.println("Num_1 / Num_2 / Num_3 = " + (num_1 / num_2 / num_3));
            case "%" ->
                System.out.println("Num_1 % Num_2 % Num_3 = " + (num_1 % num_2 % num_3));
            default ->
                System.out.println("Invalid");
        }
    }
}
