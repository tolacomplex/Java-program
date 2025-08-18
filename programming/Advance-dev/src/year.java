
import java.util.Scanner;

public class year {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month, year;
        System.out.print("Enter year from (2015 to 2025): ");
        year = input.nextInt();
        switch (year) {
            // case for years
            case 2015, 2017, 2018, 2019, 2021, 2022, 2023, 2025 -> {
                System.out.print("Enter month from (1 to 12): ");
                month = input.nextInt();
                // define the month
                switch (month) {
                    case 2 ->
                        System.out.println("Have a 28 day");
                    case 4, 6, 9, 11 ->
                        System.out.println("Have a 30 day");
                    case 1, 3, 5, 7, 8, 10, 12 ->
                        System.out.println("Have a 31 day");
                    default ->
                        System.out.println("Invalid month");
                }
            }
            case 2016, 2020, 2024 -> {
                System.out.print("Enter month (1 to 12): ");
                month = input.nextInt();
                switch (month) {
                    case 2 ->
                        System.out.println("Have a 29 day");
                    case 4, 6, 9, 11 ->
                        System.out.println("Have a 30 day");
                    case 1, 3, 5, 7, 8, 10, 12 ->
                        System.out.println("Have a 31 day");
                    default ->
                        System.out.println("Invalid month input");
                }
            }
        }
    }
}
