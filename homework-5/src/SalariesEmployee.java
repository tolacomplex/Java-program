
public abstract class SalariesEmployee extends Employee {

    private int annaulSalary;

    public int getAnnaulSalary() {
        return annaulSalary;
    }

    public void setAnnaulSalary(int annaulSalary) {
        this.annaulSalary = annaulSalary;
    }

    public SalariesEmployee(String name, int hireYear, int annaulSalary) {
        super(name, hireYear);
        this.annaulSalary = annaulSalary;
    }

    @Override
    public double mothlyPay() {

        return annaulSalary / 12;
    }

}
