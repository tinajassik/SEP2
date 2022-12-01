package client.views.buyer.mainPageView;


import client.core.ViewHandler;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import shared.BookForSale;

public class MainPageController {

    private MainPageViewModel mainPageViewModel;
    @FXML
    private GridPane gridPaneBooks;

    @FXML
    private ListView listViewBooks;
    @FXML
    private TextField textFieldSearch;
    @FXML
    private ComboBox comboBoxAuthors;

    @FXML
    private ComboBox comboBoxGenres;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelFullName;
    @FXML
    private Button  buttonShoppingCart;
    @FXML
    private Button  buttonSignOut;

    public void init(MainPageViewModel mainPageViewModel) {
        this.mainPageViewModel = mainPageViewModel;
        labelUsername.textProperty().bindBidirectional(mainPageViewModel.getUsernameProperty());
        labelFullName.textProperty().bindBidirectional(mainPageViewModel.getFullNameProperty());
        this.mainPageViewModel = mainPageViewModel;
        this.mainPageViewModel.loadBooksForSale();
        ObservableList<BookForSale> books = mainPageViewModel.getBooksForSale();

        for (BookForSale book: books
             ) {
            listViewBooks.getItems().add(book.getBook().getTitle() + "\n " + book.getPrice());
        }

        mainPageViewModel.updateLabels();
    }
    @FXML
    public void onSignOut(ActionEvent actionEvent) {
        ViewHandler.getInstance().openSign();
    }

    @FXML
    public void onShoppingCart (ActionEvent actionEvent) {

    }

    @FXML
    public void onSearchByTitle (ActionEvent actionEvent) {

    }

    @FXML
    public void onSearchByGenres (ActionEvent actionEvent) {

    }

    @FXML
    public void onSearchByAuthors(ActionEvent actionEvent) {

    }



}
