
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input year : ");
        int year = input.nextInt();
        boolean leap = false;

        if (year % 4 == 0 && year % 100 != 0) {
            if (year % 400 == 0) {
                leap = true;
            } else {
                leap = false;
            }
            System.out.println(year + " is leap year");
        } else {
            leap = false;

            System.out.println(year + " is not leap year");

        }

    }
}
