
import java.util.Scanner;

public class Task_5 {

    public static void main(String[] args) {
        int year;
        boolean leap;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Year : ");
            year = input.nextInt();
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    leap = year % 400 == 0;
                } else {
                    leap = true;
                }
            } else {
                leap = false;
            }

            if (leap) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        }
    }
}
