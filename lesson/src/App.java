
public class App {

    public static void main(String[] args) throws Exception {
        Address addr1 = new Address("Phnompenh", "Cambodia");
        Employee emp1 = new Employee(101, "Dara", addr1);
        System.out.println(emp1);
        FullTimeEmployee ftEmployee = new FullTimeEmployee(102, "Tola", addr1, 500);
        System.out.println(ftEmployee);
        PartTimeEmployee ptEmployee = new PartTimeEmployee(103, "nang", addr1, 4, 24.99);
        System.out.println(ptEmployee.toString());
    }
}
