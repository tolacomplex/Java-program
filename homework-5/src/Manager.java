
public class Manager extends SalariesEmployee {

    public Manager(String name, int hireYear, int annaulSalary) {
        super(name, hireYear, annaulSalary);

    }

    @Override
    public double annaulPay() {
      
      return getAnnaulSalary();
    }

}
