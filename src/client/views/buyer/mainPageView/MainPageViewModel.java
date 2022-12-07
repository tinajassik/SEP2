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

    private StringProperty fullName, username, numberOfItems;
    private UserModelManager model;
    private BuyerModelManager buyerModelManager;

    private ObservableList<BookForSale> booksForSale;

    public MainPageViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        numberOfItems = new SimpleStringProperty();
        model = ModelFactory.getInstance().getUserModelManager();
        buyerModelManager = ModelFactory.getInstance().getBuyerModelManager();
        buyerModelManager.addPropertyChangeListener("NewBookForSale", this::onNewBookForSale);
        buyerModelManager.addPropertyChangeListener("New number of items", this::newNumberOfItems);
        buyerModelManager.addPropertyChangeListener("BookForSaleDeleted", this::onBookForSaleDeleted);
    }

    private void onNewBookForSale(PropertyChangeEvent evt) {
        System.out.println("book new for sale in view model");
        Platform.runLater(() -> booksForSale.add((BookForSale) evt.getNewValue()));
    }

    private void onBookForSaleDeleted(PropertyChangeEvent evt) {
        System.out.println("book deleted in view model");
//        BookForSale book = (BookForSale) evt.getNewValue();
//        System.out.println(book);
//        for (BookForSale bookY: booksForSale
//             ) {
//            System.out.println(bookY);
//        }
        Platform.runLater(() -> booksForSale.remove((BookForSale) evt.getNewValue()));
//        for (BookForSale bookY: booksForSale
//        ) {
//            System.out.println(bookY);
//        }
    }
    public StringProperty getFullNameProperty() {
        return fullName;
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public StringProperty getNumberOfItemsProperty(){return numberOfItems;}

    public void newNumberOfItems(PropertyChangeEvent evt)
    {
        numberOfItems.set(Integer.toString(buyerModelManager.getShoppingCart().size()));
    }

    public void setNumberOfItems()
    {
        numberOfItems.set(Integer.toString(buyerModelManager.getShoppingCart().size()));
    }

    public void updateLabels()
    {
        username.set(model.getUser().getUsername());
        fullName.set(model.getUser().getFullName());
    }

    public ObservableList<BookForSale> getBooksForSale() {
        return booksForSale;
    }
    void loadBooksForSale() {
        List<BookForSale> booksForSaleList = buyerModelManager.getBooks();
        booksForSale = FXCollections.observableArrayList(booksForSaleList);
    }


    public ObservableList<BookForSale> searchBooksByTitle(String title)
    {
        List<BookForSale> searchedBooks = buyerModelManager.searchBooksByTitle(title);

        return FXCollections.observableArrayList(searchedBooks);
    }

    public ArrayList<Genre> getAllGenres()
    {
        return buyerModelManager.getAllGenres();
    }

    public ObservableList<BookForSale> searchBooksByGenre(String genre)
    {
        List<BookForSale> searchedBooks = buyerModelManager.searchBooksByGenre(genre);

        return FXCollections.observableArrayList(searchedBooks);
    }

    public ObservableList<BookForSale> searchBooksByAuthor(String authorFName, String authorLName)
    {
        List<BookForSale> searchedBooks = buyerModelManager.searchBooksByAuthor(authorFName, authorLName);

        return FXCollections.observableArrayList(searchedBooks);
    }

    public ArrayList<Author> getAllAuthors()
    {
        return buyerModelManager.getAllAuthors();
    }

}
