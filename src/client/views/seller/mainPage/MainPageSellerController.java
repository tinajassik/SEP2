package client.views.seller.mainPage;


import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import shared.Author;
import shared.BookForSale;

import java.util.ArrayList;

public class MainPageSellerController {



    private MainPageSellerViewModel mainPageViewModel;
    private ViewHandler viewHandler;
    @FXML
    private TextField textFieldSearch;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelFullName;
    @FXML
    private Button buttonAddBook;
    @FXML
    private Button buttonSignOut;
    @FXML private Button buttonModify;
    @FXML private  ListView listViewBooks;

    @FXML private Button buttonSearch;

    public void init(ViewHandler viewHandler, MainPageSellerViewModel mainPageSellerViewModel) {
        mainPageViewModel = mainPageSellerViewModel;
        this.viewHandler = viewHandler;
        labelFullName.textProperty().bindBidirectional(mainPageViewModel.getFullNameProperty());
        labelUsername.textProperty().bindBidirectional(mainPageViewModel.getUsernameProperty());
        mainPageViewModel.updateLabels();
        listViewBooks.getItems().setAll(mainPageViewModel.loadBooksForSale().getItems());

    }



    @FXML
    public void onSignOut(ActionEvent actionEvent) {
        viewHandler.openSign();
    }

    @FXML
    public void onButtonAddBook(ActionEvent actionEvent) {
        viewHandler.openAddBook();
    }

    @FXML
    public void onSearchByTitle(ActionEvent actionEvent) {

    }

//    public ListView getListViewBooks() {
//        return listViewBooks;
//    }
    @FXML
    public void onButtonModify(ActionEvent actionEvent) {
        if (listViewBooks.getSelectionModel().getSelectedItem() != null) {
            ViewHandler.getInstance().openBookDetailsSeller();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You have not selected any book :(");
            alert.show();
        }
    }

    public BookForSale sendBookToDetailsView() {
        return (BookForSale) listViewBooks.getSelectionModel().getSelectedItem();
    }




}
