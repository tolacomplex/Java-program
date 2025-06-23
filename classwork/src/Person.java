
public class Person {

    private String name = null;

    public Person(String name) {
      this.name = name;
    }

    public void Display() {
        System.out.println("Name: " + name);
    }

    public String getName() {
        return name;
    }


}
