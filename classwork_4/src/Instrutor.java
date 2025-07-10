
public class Instrutor extends Person {

    protected double salary;

    public Instrutor(String name) {
        super(name);
    }

    public Instrutor(String name, double salary) {
      super(name);
      this.salary = salary;
    }

    @Override
    public void Display() {
      System.out.println("Salary: $" + salary);
    }
}
