
public abstract class HourlyEmployee extends Employee {

    protected int hoursPerWeek;
    protected double hourlyWage;

    public HourlyEmployee(String name, int hireYear, int hoursPerWeek, double hourlyWage) {
        super(name, hireYear);
        this.hoursPerWeek = hoursPerWeek;
        this.hourlyWage = hourlyWage;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public double mothlyPay() {

        return hoursPerWeek * hourlyWage * 4;
    }

}
