
public class SalariesEmployee extends Employee {

    protected int anualSalaries;

    public SalariesEmployee(int anualSalaries) {
        this.anualSalaries = anualSalaries;
    }

    @Override
    void monthlyPay() {

      throw new UnsupportedOperationException("Unimplemented method 'monthlyPay'");
    }

    @Override
    void anualPay() {

      throw new UnsupportedOperationException("Unimplemented method 'anualPay'");
    }


  
}
