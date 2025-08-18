
public class Movie {

    String title;
    String author;
    int duration;

    public Movie() {
        title = "Uknown";
        author = "Unknown";
        duration = 0;
    }

    public Movie(String title, String author, int duration) {
        this.title = title;
        this.author = author;
        this.duration = duration;
    }

    public void display() {
        System.out.println("\nTitle: " + title);
        System.out.println("Author: " + author);
        System.out.println("duration: " + duration);
    }

}
