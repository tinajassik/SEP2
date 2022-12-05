package client.views.seller.mainPage;

import client.core.ModelFactory;
import client.model.SellerModelManager;
import client.model.UserModelManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import shared.BookForSale;

import java.util.List;

public class MainPageSellerViewModel {

    private StringProperty fullName;
    private StringProperty username;
    private UserModelManager userModelManager;
    private SellerModelManager sellerModelManager;
    private ObservableList<BookForSale> books;

    public MainPageSellerViewModel() {
        fullName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        userModelManager = ModelFactory.getInstance().getUserModelManager();
        sellerModelManager = ModelFactory.getInstance().getSellerModelManager();
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
    public  ListView loadBooksForSale() {
        List<BookForSale> booksForSaleList = sellerModelManager.getBooksSoldByMe(username.get());
        ListView listView = new ListView<>();
        System.out.println(booksForSaleList.get(0).getBook());
        for (BookForSale book: booksForSaleList) {
            listView.getItems().add(book);
        }
        return listView;
//        books = FXCollections.observableArrayList(booksForSaleList);
//        books.setAll(booksForSaleList);

    }

}
