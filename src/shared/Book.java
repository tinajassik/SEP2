package shared;
public class Book {
    private String title;
    private String isbn;
    private Author author;
    private String genre;
    private String condition;
    private double price;
    private String coverType;
    private int YearOfPublish;

    public Book (String isbn, String title, String genre, String condition, String coverType, Author author, int YearOfPublish, double price){
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.title = title;
        this.condition = condition;
        this.coverType = coverType;
        this.price = price;
        this.YearOfPublish = YearOfPublish;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getYearOfPublish() {
        return YearOfPublish;
    }


    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getCoverType() {return coverType;}

    public void setAuthor(Author author) {
        this.author = author;
    }


    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfPublish(int yearOfPublish) {
        YearOfPublish = yearOfPublish;
    }

    public String toString(){

        return "Title: " +title +"\n" +
                author +
                "ISBN: " +isbn +"\n" +
                "Genre: " + genre +"\n" +
                "Cover type: " + coverType + "\n" +
                "Price: " + price + "\n" +
                "Year publication: " + YearOfPublish;

    }

}
