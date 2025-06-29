
public class EmployeeInfo {

    protected int id;
    protected String name;
    protected double Salary;

    public EmployeeInfo(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        Salary = salary;
    }

    @Override
    public String toString() {
      return "EmployeeInfo [id = " + id + ", name = " + name + ", Salary = $" + Salary + "]";
    }

}
