
public abstract class Employee {

    private String name;
    private int id;

    public Employee() {
        name = null;
        id = 0;
    }

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract double calculateSalary();

    public void showDetail() {
        System.out.println("name: " + name);
        System.out.println("id: " + id);
    }

}
