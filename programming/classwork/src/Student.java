
public class Student {

    String name;
    double attendanceScore;
    double assignmentScore;
    double midtermScore;
    double finalScore;
    double average;
    double gpa;

    public Student() {
        name = null;
        attendanceScore = 0.0;
        assignmentScore = 0.0;
        midtermScore = 0.0;
        finalScore = 0.0;
        average = 0.0;
        gpa = 0.0;
    }

    public Student(String name, double attendanceScore, double assignmentScore, double midtermScore, double finalScore, double average, double gpa) {
        this.name = name;
        this.attendanceScore = attendanceScore;
        this.assignmentScore = assignmentScore;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
        this.average = average;
        this.gpa = gpa;
    }

    public void displayInfo() {
        System.out.println("\n\n");
        System.out.println("Name: " + name);
        System.out.println("Attendance Score: " + attendanceScore);
        System.out.println("Assignment Score: " + assignmentScore);
        System.out.println("Midterm Score: " + midtermScore);
        System.out.println("Final Score: " + finalScore);
        System.out.println("Average: " + average + "%");
        System.out.println("GPA: " + gpa);
    }

    public static void main(String[] args) {
        String name = "Tola Ouen";
        double attendanceScore = 15;
         
        double assignmentScore = 15;
        double midtermScore = 10;
        double finalScore = 60;
// Find the average of student
        double average = assignmentScore + attendanceScore + midtermScore + finalScore;
        double gpa = 0;
// Check condition in average. student
        if (average > 90 && average <= 100) {
            gpa = 4.0;
        } else if (average > 80 && average <= 89) {
            gpa = 3.0;
        } else if (average > 70 && average <= 79) {
            gpa = 2.0;
        } else if (average > 60 && average <= 69) {
            gpa = 1.0;
        } else if (average < 60) {
            gpa = 0.0;
        }
// Call function method above
        Student student = new Student(name, attendanceScore, assignmentScore, midtermScore, finalScore, average, gpa);
        student.displayInfo();
    }
}
