
public class App {

    public static void checkAge(int age) throws MyException {
        if (age < 18) {
            throw new MyException("Age must be greater than 18");
        } else if (age == 0) {
            throw new IllegalArgumentException("Age must be greater than 18");

        }
        System.out.println("Age OK");
    }

    public static void main(String[] args) {
        try {

            checkAge(15); // Throws exception

        } catch (MyException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
