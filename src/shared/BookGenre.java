package shared;

public class BookGenre {

    private String genreName;
    private String isbn;

    public BookGenre(String genreName, String isbn) {
        this.genreName = genreName;
        this.isbn = isbn;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
