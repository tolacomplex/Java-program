
import java.util.Scanner;

public class Task_2 {

    int Add(int number_1, int number_2) {
        return number_1 + number_2;
    }

    int Subtract(int number_1, int number_2) {
        return number_1 - number_2;
    }

    int Multiple(int number_1, int number_2) {
        return number_1 * number_2;
    }

    int Divide(int number_1, int number_2) {
        return number_1 / number_2;
    }

    int Modulus(int number_1, int number_2) {
        return number_1 % number_2;
    }

    public static void main(String[] args) {
        Task_2 obj = new Task_2();
        Scanner input = new Scanner(System.in);
        int number, number_1, number_2;
        int result;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiple");
            System.out.println("4. Divide");
            System.out.println("5. Modulus");
            System.out.println("6. Exit");
            System.out.print("Input number: ");
            number = input.nextInt();
            if (number == 1) {
                System.out.print("Number 1 : ");
                number_1 = input.nextInt();
                System.out.print("Number 2 : ");
                number_2 = input.nextInt();
                result = obj.Add(number_1, number_2);
                System.out.println("Result = " + result);
            } else if (number == 2) {
                System.out.print("Number 1 : ");
                number_1 = input.nextInt();
                System.out.print("Number 2 : ");
                number_2 = input.nextInt();
                result = obj.Subtract(number_1, number_2);
                System.out.println("Result = " + result);
            } else if (number == 3) {
                System.out.print("Number 1 : ");
                number_1 = input.nextInt();
                System.out.print("Number 2 : ");
                number_2 = input.nextInt();
                result = obj.Multiple(number_1, number_2);
                System.out.println("Result = " + result);
            } else if (number == 4) {
                System.out.print("Number 1 : ");
                number_1 = input.nextInt();
                System.out.print("Number 2 : ");
                number_2 = input.nextInt();
                result = obj.Divide(number_1, number_2);
                System.out.println("Result = " + result);
            } else if (number == 5) {
                System.out.print("Number 1 : ");
                number_1 = input.nextInt();
                System.out.print("Number 2 : ");
                number_2 = input.nextInt();
                result = obj.Modulus(number_1, number_2);
                System.out.println("Result = " + result);
            } else if (number == 6) {
                System.out.println("Exit succesfull. Thank you");
                break;
            } else {
                System.out.println("Invalid input. Please try again (1 - 6)");
            }

        }
    }
}
