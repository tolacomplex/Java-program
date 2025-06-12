
import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        double fahrenheit, celsius;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Input a degree in Fahrenheit: ");
            fahrenheit = input.nextDouble();
            celsius = (fahrenheit - 32) / 1.8;
            System.out.println((double) fahrenheit + " degree Fahrenheit is equal to " + (double) celsius + " in celsius");
        } catch (Exception e) {
            System.out.println("Error occur invalid input");
        }
    }
}
