
public class Developer extends Employee {

    private int hoursWorked;
    private double hourslyRate;

    public Developer() {
        hoursWorked = 0;
        hourslyRate = 0.0;
    }

    public Developer(String name, int id, int hoursWorked, double hourslyRate) {
        this.hoursWorked = hoursWorked;
        this.hourslyRate = hourslyRate;
    }

    @Override
    public double calculateSalary() {

        return hoursWorked * hourslyRate;
    }

    public void showDetail() {
        System.out.println("Hours worked: " + hoursWorked);
        System.out.println("Hoursly Rate: $" + hourslyRate);
        System.out.println("Total: $" + calculateSalary());
    }

}
