package client.views.seller.addBooksView;

import client.core.ModelFactory;
import client.model.SellerModelManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.Author;
import shared.Genre;

import java.util.ArrayList;

public class AddBooksViewModel {

    private StringProperty  title, coverType, Author, isbn, genre,  yearOfPublication;
    private SellerModelManager sellerModelManager;
    public AddBooksViewModel(){
        this.title = new SimpleStringProperty();
        this.coverType = new SimpleStringProperty();
        this.Author = new SimpleStringProperty();
        this.isbn = new SimpleStringProperty();
        this.genre = new SimpleStringProperty();
        this.yearOfPublication = new SimpleStringProperty();
        sellerModelManager = ModelFactory.getInstance().getSellerModelManager();

    }

    public ArrayList<Author> getAuthors() {
        return sellerModelManager.getAuthors();
    }

    public ArrayList<Genre> getGenres() {
        return sellerModelManager.getGenres();
    }

    public void addBook(String title, String isbn, String coverType, int publicationYear, Author author, ArrayList<Genre> genres) {
        sellerModelManager.AddBook(title,isbn, coverType,publicationYear, author,genres);
    }

    public StringProperty coverTypeProperty() {
        return coverType;
    }


    public StringProperty authorProperty() {
        return Author;
    }

    public String getIsbn() {
        return isbn.get();
    }

    public StringProperty isbnProperty() {
        return isbn;
    }


    public StringProperty genreProperty() {
        return genre;
    }

    public StringProperty titleProperty() {
        return title;
    }
    public StringProperty yearOfPublicationProperty() {
        return yearOfPublication;
    }
}
