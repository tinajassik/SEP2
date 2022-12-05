package client.views.buyer.mainPageView;

import client.core.ModelFactory;
import client.model.BuyerModelManager;
import client.model.UserModelManager;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import shared.Author;

//import javafx.collections.ObservableListBase;

import shared.BookForSale;
import shared.Genre;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class MainPageViewModel {

    private StringProperty fullName;
    private StringProperty username;
    private UserModelManager model;
    private BuyerModelManager buyerModelManager;

    private ObservableList<BookForSale> booksForSale;

    public MainPageViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        model = ModelFactory.getInstance().getUserModelManager();
        buyerModelManager = ModelFactory.getInstance().getBuyerModelManager();
        buyerModelManager.addPropertyChangeListener("NewBookForSale", this::onNewBookForSale);
    }

    private void onNewBookForSale(PropertyChangeEvent evt) {
        System.out.println("observer in view model");
        Platform.runLater(() -> booksForSale.add((BookForSale) evt.getNewValue()));
    }
    public StringProperty getFullNameProperty() {
        return fullName;
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public void updateLabels()
    {
        username.set(model.getUser().getUsername());
        fullName.set(model.getUser().getFullName());
    }

    ObservableList<BookForSale> getBooksForSale() {
        return booksForSale;
    }
    void loadBooksForSale() {
        List<BookForSale> booksForSaleList = buyerModelManager.getBooks();
        booksForSale = FXCollections.observableArrayList(booksForSaleList);
    }


    ObservableList<BookForSale> searchBooksByTitle(String title)
    {
        List<BookForSale> searchedBooks = buyerModelManager.searchBooksByTitle(title);

        return FXCollections.observableArrayList(searchedBooks);
    }

    ArrayList<Genre> getAllGenres()
    {
        return buyerModelManager.getAllGenres();
    }

    ObservableList<BookForSale> searchBooksByGenre(String genre)
    {
        List<BookForSale> searchedBooks = buyerModelManager.searchBooksByGenre(genre);

        return FXCollections.observableArrayList(searchedBooks);
    }

    ObservableList<BookForSale> searchBooksByAuthor(String authorFName, String authorLName)
    {
        List<BookForSale> searchedBooks = buyerModelManager.searchBooksByAuthor(authorFName, authorLName);

        return FXCollections.observableArrayList(searchedBooks);
    }

    public ArrayList<Author> getAllAuthors()
    {
        return buyerModelManager.getAllAuthors();
    }

}
