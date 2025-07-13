
public class PartTime extends HourlyEmployee {

  public PartTime(String name, int hireYear, int hoursPerWeek, double hourlyWage) {
    super(name, hireYear, hoursPerWeek, hourlyWage);
  }

  @Override
  public double annaulPay() {
    //
    return getHourlyWage() * getHoursPerWeek() * 52;
  }

   

}
