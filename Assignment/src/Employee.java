
public class Employee {

    String name;
    double baseSalary;
    double salaryCoefficient;

    public Employee() {
        name = "Unknown";
        baseSalary = 0.0;
        salaryCoefficient = 0.0;
    }

    public Employee(String name, double baseSalary, double salaryCoefficient) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.salaryCoefficient = salaryCoefficient;
    }

    public double calculatSalary() {
        return baseSalary * salaryCoefficient;

    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Salary Co Efficient: $" + salaryCoefficient);
        System.out.println("Calculate Salary: $" + calculatSalary());
    }
}
