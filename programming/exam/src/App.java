
public class App {

    String name;
    double att_score, ass_score, mid_score, final_score, avg_score, gpa;

    public App() {
        name = "Unknown";
        att_score = 0.0;
        ass_score = 0.0;
        mid_score = 0.0;
        final_score = 0.0;
        avg_score = 0.0;
        gpa = 0.0;
    }

    public App(String name, double att_score, double ass_score, double mid_score, double final_score) {
        this.name = name;
        this.att_score = att_score;
        this.ass_score = ass_score;
        this.mid_score = mid_score;
        this.final_score = final_score;
        calculateAvg();
        calculategpa();
    }

    double calculateAvg() {
        avg_score = att_score + ass_score + mid_score + final_score;
        return avg_score;
    }

    void calculategpa() {
        if (avg_score >= 90 && ass_score <= 100) {
            gpa = 4.0;
        } else if (avg_score >= 80 && avg_score <= 89) {
            gpa = 3.0;
        } else if (avg_score >= 70 && avg_score <= 79) {
            gpa = 2.0;
        } else if (avg_score >= 60 && avg_score <= 69) {
            gpa = 1.0;
        } else if (avg_score < 60) {
            gpa = 0.0;
        }
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Attendend Scores: " + att_score);
        System.out.println("Assignment Scores: " + ass_score);
        System.out.println("Mid-term Scores: " + mid_score);
        System.out.println("Final Scores: " + final_score);
        System.out.println("Average Scores: " + avg_score);
        System.out.println("GPA: " + gpa);
    }

    public static void main(String[] args) throws Exception {
        App s1 = new App("Tola Ouen", 10, 14, 15, 50);
        s1.displayInfo();
    }
}
