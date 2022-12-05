package client.views.seller.mainPage;


import client.core.ViewHandler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

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
    @FXML private ListView listViewBooks;

    @FXML private Button buttonSearch;

    public void init(ViewHandler viewHandler, MainPageSellerViewModel mainPageSellerViewModel) {
        mainPageViewModel = mainPageSellerViewModel;
        this.viewHandler = viewHandler;
        labelFullName.textProperty().bindBidirectional(mainPageViewModel.getFullNameProperty());
        labelUsername.textProperty().bindBidirectional(mainPageViewModel.getUsernameProperty());
        mainPageViewModel.updateLabels();
        mainPageViewModel.loadBooksForSale();
        listViewBooks.setItems(mainPageSellerViewModel.getBooksSoldBySeller());
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


}
