
public class Course {

    private String courseNo;
    private Student student;
    private Instrutor instrutor;

    public Course(String course, String t, double sal) {
        this.courseNo = course;
        this.instrutor = new Instrutor(t, sal);
    }

    public Course() {
        this.courseNo = "";
    }

    public void setStudents(String n, double g) {
        this.student = new Student(n, g);
    }

    public void display() {
        System.out.println("Course No: " + courseNo);
        if (instrutor != null) {
            instrutor.Display();
        }
        if (student != null) {
            student.Display();
        }
      }
}
