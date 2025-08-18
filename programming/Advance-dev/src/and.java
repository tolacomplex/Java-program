
public class and {

    public static void main(String[] args) {
        int i = 0;
        int j = 5;
        boolean test = false;
        test = (i > 5) && (j++ > 4);
        System.out.println("i = " + i + "\n" + "j = " + j);
        System.out.println("&& Evaluation result test = " + test);
        test = (i > 5) & (j++ > 4);
        System.out.println("i = " + i + "\n" + "j = " + j);
        System.out.println("& Evaluation result test = " + test);
    }
}
