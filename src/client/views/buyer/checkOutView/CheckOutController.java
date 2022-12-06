package client.views.buyer.checkOutView;

import client.core.ViewHandler;
import client.views.buyer.mainPageView.MainPageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class CheckOutController {

    private MainPageViewModel mainPageViewModel;
    @FXML
    private ListView listViewBooks;
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

    public void init(CheckOutViewModel checkOutViewModel) {
        this.mainPageViewModel = mainPageViewModel;
        //fill out listview with books in cart
        //listViewBooks.setItems(this.mainPageViewModel.getBooksForSale());
        labelUsername.textProperty().bindBidirectional(mainPageViewModel.getUsernameProperty());
        labelFullName.textProperty().bindBidirectional(mainPageViewModel.getFullNameProperty());
    }


    public void onSeeDetails(){
        if (listViewBooks.getSelectionModel().getSelectedItem() != null) {
            ViewHandler.getInstance().openBookDetails();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You have not selected any book BITCH:(");
            alert.show();
        }
    }





}
