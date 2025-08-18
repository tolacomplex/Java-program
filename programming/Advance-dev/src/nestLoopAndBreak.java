
public class nestLoopAndBreak {

    public static void main(String[] args) {
        for (int i = 0; i <= 3; i++) {
            System.out.println("Outer loop " + (i + 1) + " : ");
            for (int j = 0; j < 100; j++) {
                System.out.print(j + " ");
                if (j == 10) {
                    System.out.println("\nBreak the loop");
                    break;
                }
                System.out.print(" ");
            }
        }
        System.out.println("Break The Loop Complete.");
    }

}
 