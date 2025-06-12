
import java.util.Scanner;

public class Task_4 {

    public static void main(String[] args) {
        String operator;
        int number_1, number_2, result;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("First number: ");
            number_1 = input.nextInt();
            System.out.print("Second number: ");
            number_2 = input.nextInt();
            System.out.print("Input operator (+ - * /): ");
            operator = input.next();

            switch (operator) {
                case "+" -> {
                    result = number_1 + number_2;
                    System.out.println(number_1 + " + " + number_2 + " = " + result);
                }
                case "-" -> {
                    result = number_1 - number_2;
                    System.out.println(number_1 + " - " + number_2 + " = " + result);
                }
                case "*" -> {
                    result = number_1 * number_2;
                    System.out.println(number_1 + " * " + number_2 + " = " + result);
                }
                case "/" -> {
                    result = number_1 / number_2;
                    System.out.println(number_1 + " / " + number_2 + " = " + result);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

}
