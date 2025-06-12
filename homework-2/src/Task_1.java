
import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) throws Exception {
        String word;
        Scanner input = new Scanner(System.in);
        System.out.print("Input word: ");
        word = input.nextLine();
        int count = word.split("\\s").length;
        System.out.println("Number of word in string = " + count);

    }
}
