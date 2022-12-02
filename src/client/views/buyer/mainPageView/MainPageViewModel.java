package client.views.buyer.mainPageView;

import client.core.ModelFactory;
import client.model.BuyerModelManager;
import client.model.UserModelManager;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.BookForSale;

import java.beans.PropertyChangeEvent;
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

//    void loadLogs() {
//        List<BookForSale> logList = buyerModelManager.getLogs();
//        logs = FXCollections.observableArrayList(logList);
//    }

    ObservableList<BookForSale> getBooksForSale() {
        return booksForSale;
    }
    void loadBooksForSale() {
        List<BookForSale> booksForSaleList = buyerModelManager.getBooks();
        booksForSale = FXCollections.observableArrayList(booksForSaleList);
    }

    }
