
class Manager extends Employee {

    private double bonus;
    
    public Manager() {
      bonus = 0.0;
    }

    public Manager(String name, int id, double bonus) {
        super(name, id);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return bonus;
    }

    @Override
    public void showDetail() {
        System.out.println("Bonus: $" + bonus);
    }

}
