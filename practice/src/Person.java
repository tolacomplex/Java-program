
public class Person {

    private int age;
    private String name;

    public Person() {
        age = 0;
    }
    public void sayAsk() {
      System.out.println("Hello is " + age);
    }
    public void setAge(int age) {
      this.age = age;
    }
    public void setName(String name) {
      this.name = name;
    }
    public int getAge() {
      return age;
    }
    public String getName() {
      return name;
    }

}
