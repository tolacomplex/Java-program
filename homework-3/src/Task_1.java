
import java.util.Scanner;

public class Task_1 {

    static double hourRateperWeek(double hourRate) {
        return hourRate * (50 * 40);
    }

    static void showResult(double hourRateperWeek, String Ename) {

        System.out.println(Ename + "'s annaul salary is $" + hourRateperWeek);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String Ename;
            double hourRate;
            System.out.print("How many employees? ");
            int number = input.nextInt();

            for (int i = 0; i < number; i++) {
                System.out.print("Please enter employee name #" + (i + 1) + " : ");
                Ename = input.next();
                System.out.print("Please enter hoursly rate of " + Ename + "  : ");
                hourRate = input.nextDouble();
                double answer = hourRateperWeek(hourRate);
                showResult(answer, Ename);
            }
        }

    }

}
