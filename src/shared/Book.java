package shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    private String title;
    private String isbn;
    private Author author;
    private ArrayList<Genre> genres;
    private String coverType;
    private int YearOfPublish;

    public Book (String isbn, String title,  int YearOfPublish, String coverType, Author author, ArrayList<Genre> genres){
        this.author = author;
        this.isbn = isbn;
        this.title = title;
        this.coverType = coverType;
        this.YearOfPublish = YearOfPublish;
        this.genres = genres;
    }

    public Author getAuthor() {
        return author;
    }



    public int getYearOfPublish() {
        return YearOfPublish;
    }


    public ArrayList<Genre> getGenre() {
        return genres;
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

    public void setGenre(ArrayList<Genre> genres) {
        for (int i = 0; i < genres.size(); i++) {
            this.genres.add(genres.get(i));
        }
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
                "Genre: " + genres.toString() +"\n" +
                "Cover type: " + coverType + "\n" +
                "Year publication: " + YearOfPublish;

    }

}
