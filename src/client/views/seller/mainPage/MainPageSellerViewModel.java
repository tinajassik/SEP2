package client.views.seller.mainPage;

import client.core.ModelFactory;
import client.model.SellerModelManager;
import client.model.UserModelManager;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import shared.BookForSale;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class MainPageSellerViewModel {

    private StringProperty fullName;
    private StringProperty username;
    private StringProperty title;
    private UserModelManager userModelManager;
    private SellerModelManager sellerModelManager;
    private ObservableList<BookForSale> books;

    public MainPageSellerViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        title = new SimpleStringProperty();
        userModelManager = ModelFactory.getInstance().getUserModelManager();
        sellerModelManager = ModelFactory.getInstance().getSellerModelManager();
        sellerModelManager.addPropertyChangeListener("BookForSaleDeleted", this::onBookSold);
    }

    private void onBookSold(PropertyChangeEvent evt) {
        Platform.runLater(() -> books.remove((BookForSale) evt.getNewValue()));
    }
    public String getFullName() {
        return fullName.get();
    }

    public StringProperty getFullNameProperty() {
        return fullName;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public StringProperty getTitleProperty() {
        return title;
    }

    public void updateLabels()
    {
        username.set(userModelManager.getUser().getUsername());
        fullName.set(userModelManager.getUser().getFullName());
    }

//    public List<BookForSale> getBooksSoldBy() {
//        return sellerModelManager.getBooksSoldByMe(username.get());
//    }

    ObservableList<BookForSale> getBooksSoldBySeller() {
        return books;
    }
    public  ListView getBooksForSale() {
        List<BookForSale> booksForSaleList = sellerModelManager.getBooksSoldByMe(username.get());
        ListView listView = new ListView<>();

        for (BookForSale book: booksForSaleList) {
            listView.getItems().add(book);
        }
        return listView;
    }
    void loadBooksForSale() {
        List<BookForSale> bookForSaleList = sellerModelManager.getBooksSoldByMe(username.get());
        books = FXCollections.observableArrayList(bookForSaleList);
    }

    public ObservableList<BookForSale> searchBooksByTitle() {
        List<BookForSale> searchedBooks = sellerModelManager.searchBooksByTitle(title.get());
        return FXCollections.observableArrayList(searchedBooks);
    }

}
