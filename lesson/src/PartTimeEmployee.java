
public class PartTimeEmployee extends Employee {

    private double hours;
    private double rates;

    public PartTimeEmployee(double hours, double rates) {
        this.hours = hours;
        this.rates = rates;
    }

    public PartTimeEmployee(int id, String name, double hours, double rates) {
        super(id, name);
        this.hours = hours;
        this.rates = rates;
    }

    public PartTimeEmployee(int id, String name, Address address, double hours, double rates) {
        super(id, name, address);
        this.hours = hours;
        this.rates = rates;
    }

    public double getHours() {
        return hours;
    }

    public double getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee [hours=" + hours + ", rates=" + rates + "]";
    }

}
