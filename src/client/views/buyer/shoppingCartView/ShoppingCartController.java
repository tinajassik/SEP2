package client.views.buyer.shoppingCartView;

import client.core.ViewHandler;
import client.views.buyer.mainPageView.MainPageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ShoppingCartController {

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
    private Label labelPrice;
    @FXML
    private Button buttonMainPage;
    @FXML
    private Button buttonSignOut;
    @FXML
    private Button buttonCheckOut;
    private ShoppingCartViewModel shoppingCartViewModel;

    public void init(ShoppingCartViewModel shoppingCartViewModel) {
        this.shoppingCartViewModel = shoppingCartViewModel;
        labelUsername.textProperty().bindBidirectional(mainPageViewModel.getUsernameProperty());
        labelFullName.textProperty().bindBidirectional(mainPageViewModel.getFullNameProperty());
    }

    @FXML
    public void onSignOut(ActionEvent actionEvent) {
        ViewHandler.getInstance().openSign();
    }


}
