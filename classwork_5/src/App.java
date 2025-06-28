
public class App {

    public static void main(String[] args) throws Exception {
        Employee manager = new Manager("Rotha sopheak", 123, 50.0);
        Employee developer = new Developer("Ouen Tola", 011, 45, 25.0);

        Payroll payroll = new Payroll();
        payroll.processPayment(manager);
        payroll.processPayment(developer);
    }
}
