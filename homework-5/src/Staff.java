
public class Staff extends SalariesEmployee {

    public Staff(String name, int hireYear, int annaulSalary) {
        super(name, hireYear, annaulSalary);
    }

    @Override
    public double annaulPay() {
        return getAnnaulSalary();
    }
;

}
