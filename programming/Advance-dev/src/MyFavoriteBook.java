
public class MyFavoriteBook {

    String title;
    String author;
    String language;

    public MyFavoriteBook(String title, String author, String language) {
        this.title = title;
        this.author = author;
        this.language = language;
    }

    public void DisplayInformation() {
        System.out.println("Book Title: " + title);
        System.out.println("Book Author: " + author);
        System.out.println("Book Language: " + language);
    }

}
