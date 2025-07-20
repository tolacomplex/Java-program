
public class HeadOfDepartment extends Employee {

    int year;
    String position;

    public HeadOfDepartment() {
        year = 0;
        position = "Unknown";
    }

    public HeadOfDepartment(int year, String position) {
        this.year = year;
        this.position = position;
    }

    public HeadOfDepartment(String name, double baseSalary, double salaryCoefficient, int year, String position) {
        super(name, baseSalary, salaryCoefficient);
        this.year = year;
        this.position = position;
    }

    @Override
    public void displayInfo() {
        System.out.println("Position: " + position);
        System.out.println("Year: " + year);
        super.displayInfo();
        System.out.println("\n");
    }
}
