package client.views.buyer.mainPageView;


import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MainPageController {

    private MainPageViewModel mainPageViewModel;
    @FXML
    private GridPane gridPaneBooks;
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
