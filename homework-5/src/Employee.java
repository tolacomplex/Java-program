
public abstract class Employee {

    protected String name;
    protected int hireYear;

    public Employee(String name, int hireYear) {
        this.name = name;
        this.hireYear = hireYear;
    }

    public abstract double mothlyPay();

    public abstract double annaulPay();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

}
