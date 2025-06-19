
public class FullTimeEmployee extends Employee {

    private double salary;

    public FullTimeEmployee(double salary) {
        super();
        this.salary = salary;
    }

    public FullTimeEmployee(double salary, int id, String name) {
        super(id, name);
        this.salary = salary;
    }

    public FullTimeEmployee(double salary, String id, Address addr1, double address) {
        super();
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
      return "FullTimeEmployee [salary=" + salary +  "]";
    }
    

}
