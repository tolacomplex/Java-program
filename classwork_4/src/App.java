
public class App {

    public static void main(String[] args) throws Exception {
        // Person 
        Person p1 = new Person("Tola");
        p1.Display();
        String name = p1.getName();
        // Student
        Student s = new Student(name, 4.0);
        s.Display();
        // Instrucotor
        Instrutor i = new Instrutor(name, 750);
        i.Display();
        // Courses
        Course c = new Course("Software Development", "1", 500);
        c.display();
    }
}
