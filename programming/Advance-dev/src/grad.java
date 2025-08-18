import java.util.Scanner;

public class grad {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input character (A, B, C, D, E, or F): ");
    String character = input.next();

    switch(character) {
      case "A" -> System.out.println("Grad A is the best.");
      case "B" -> System.out.println("Grad B is very good.");
      case "C" -> System.out.println("Grad C is good.");
      case "D" -> System.out.println("Grad D is medium.");
      case "E" -> System.out.println("Grad E is lower.");
      case "F" -> System.out.println("Grad F is Fail.");
      default -> System.out.println("Invaid");
    }
  }
}
