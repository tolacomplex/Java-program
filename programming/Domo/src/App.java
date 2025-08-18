
public class App {

    public static void main(String[] args) throws Exception {
        Movie movie = new Movie("Koleap Pailen", "Tola", 125);
        movie.display();
        Movie movie1 = new Movie("Avatar", "Jonh", 90);
        movie1.display();
        Movie movie2 = new Movie();
        movie2.display();
    }
}
