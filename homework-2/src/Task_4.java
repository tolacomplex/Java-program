
import java.util.Scanner;

public class Task_4 {

    public static void Matrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((int) (Math.random() * 2) + "");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Input a number: ");
        n = input.nextInt();
        Task_4.Matrix(n);

    }
}
