
public class Student extends Person {

    protected  double gpa;
    
    public Student(String name, double gpa) {
      super(name);
      this.gpa = gpa;
    }

    @Override
   public void Display() {
    System.out.println("GPA: " + gpa);
   }


}
