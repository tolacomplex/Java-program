
public class App extends MyFavoriteBook {

    public App(String title, String author, String language) {
        super(title, author, language);
    }

    public static void main(String[] args) {
        String title, author, language;
        title = "Mini Habits";
        author = "Stephen Guise";
        language = "English";
        MyFavoriteBook book = new MyFavoriteBook(title, author, language);
        book.DisplayInformation();
        System.out.println("The reason that I love it. Because this book teach me about start from mini habits become a good habits.");
    }

}
