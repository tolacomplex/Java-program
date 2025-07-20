
public class Main {

    public static void main(String[] args) throws Exception {
        Employee em = new HeadOfDepartment();
        Employee em1 = new HeadOfDepartment(2, "Software Development");
        Employee em2 = new HeadOfDepartment("Tola Ouen", 800.0, 12, 3, "Software Engineer");
        em.displayInfo();
        em1.displayInfo();
        em2.displayInfo();
    }
}
