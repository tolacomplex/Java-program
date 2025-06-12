
import java.util.Random;
import java.util.Scanner;

public class Task_5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "Y";

        System.out.println("Guess my number game: ");
        while (playAgain.equalsIgnoreCase("Y")) {
            int targetNumber = random.nextInt(6) + 1;
            int guessCount = 0;
            int guess = 0;
            while (guess != targetNumber) {
                System.out.print("Enter a guess between 1 and 6: ");
                if (input.hasNextInt()) {
                    guess = input.nextInt();
                    guessCount++;

                    if (guess < 1 || guess > 6) {
                        System.out.println("Please enter a number between 1 and 6.");
                    } else if (guess > targetNumber) {
                        System.out.println("Too high! The random number is " + targetNumber);
                    } else if (guess < targetNumber) {
                        System.out.println("Too low! The random number is " + targetNumber);
                    } else {
                        System.out.println("Correct! You got it in " + guessCount + " guesses!");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    input.next();  // clear invalid input
                }
                System.out.print("Do you want to play (Y or N)? ");
                playAgain = input.next();
            }
        }
    }
}
