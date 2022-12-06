package client.views.seller.bookDetails;

import client.core.ModelFactory;
import client.core.ViewHandler;
import client.model.SellerModelManager;
import client.views.seller.mainPage.MainPageSellerController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shared.Author;
import shared.Book;
import shared.BookForSale;
import shared.Genre;

import javax.swing.event.ChangeListener;
import java.util.ArrayList;


public class BookDetailsSellerViewModel {

    private StringProperty title;
    private StringProperty author;
    private StringProperty isbn;
    private StringProperty publicationYear;
    private StringProperty condition;
    private StringProperty genres;
    private StringProperty price;

    private StringProperty coverType;

    private BookForSale bookForSale;
    private SellerModelManager sellerModelManager;
    public BookDetailsSellerViewModel() {
        sellerModelManager = ModelFactory.getInstance().getSellerModelManager();
        setBook(ViewHandler.getInstance().getMainPageSellerController().sendBookToDetailsView());
        title = new SimpleStringProperty();
        condition = new SimpleStringProperty();
        publicationYear = new SimpleStringProperty();
        price = new SimpleStringProperty();
        author = new SimpleStringProperty();
        genres = new SimpleStringProperty();
        isbn = new SimpleStringProperty();
        coverType = new SimpleStringProperty();
        loadInitialData();

    }

    public void loadInitialData() {
        title.set(bookForSale.getBook().getTitle());
        condition.set(bookForSale.getCondition());
        publicationYear.set(String.valueOf(bookForSale.getBook().getYearOfPublish()));
        price.set(String.valueOf(bookForSale.getPrice()));
        author.set(String.valueOf(bookForSale.getBook().getAuthor()));
        genres.set(getGenresToString());
        isbn.set(bookForSale.getBook().getIsbn());
        coverType.set(bookForSale.getBook().getCoverType());
    }

    public String getGenresToString() {
        String genres = "";
        ArrayList<Genre> genreArrayList = bookForSale.getBook().getGenre();
        for (Genre genre:
            genreArrayList ) {
            genres += genre.getGenreName() + ", ";
        }
        return genres;
    }

    public void editBook(Author author, ArrayList<Genre> selectedGenres) {
        sellerModelManager.editBook(title.get(), isbn.get(),Integer.parseInt(publicationYear.get()),coverType.get(),condition.get(),Double.parseDouble(price.get())
                ,author,selectedGenres);
    }

    public ArrayList<Author> getAuthors() {
        return sellerModelManager.getAuthors();
    }

    public ArrayList<Genre> loadGenres() {
        return sellerModelManager.getGenres();
    }



    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty coverTypeProperty() {
        return coverType;
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public String getIsbn() {
        return isbn.get();
    }

    public StringProperty isbnProperty() {
        return isbn;
    }

    public String getPublicationYear() {
        return publicationYear.get();
    }

    public StringProperty publicationYearProperty() {
        return publicationYear;
    }

    public String getCondition() {
        return condition.get();
    }

    public StringProperty conditionProperty() {
        return condition;
    }

    public String getGenres() {
        return genres.get();
    }

    public StringProperty genresProperty() {
        return genres;
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }


    public void setBook(BookForSale book) {
        bookForSale = book;
    }
}
