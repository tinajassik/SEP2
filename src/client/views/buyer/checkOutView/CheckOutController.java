package client.views.buyer.checkOutView;

import client.core.ViewHandler;
import client.views.buyer.mainPageView.MainPageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import shared.BookForSale;

import java.util.ArrayList;

public class CheckOutController {

    private CheckOutViewModel checkOutViewModel;
    @FXML
    private ListView listViewBooks;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelFullName;

    public void init(CheckOutViewModel checkOutViewModel) {
        this.checkOutViewModel = checkOutViewModel;
        //fill out listview with books in cart
//        loadBooksFromShoppingCart();
        checkOutViewModel.loadShoppingCart();
        listViewBooks.setItems(checkOutViewModel.getShoppingCart());
        labelUsername.textProperty().bindBidirectional(checkOutViewModel.getUsernameProperty());
        labelFullName.textProperty().bindBidirectional(checkOutViewModel.getFullNameProperty());
    }


    public void onBackButton(ActionEvent actionEvent)
    {
        ViewHandler.getInstance().openShoppingCart();
    }

    public void purchase(ActionEvent actionEvent)
    {
        try
        {
            checkOutViewModel.purchase();
//            checkOutViewModel.createOrder();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Your books have been successfully purchased. We received your order. Thank you :)");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
            listViewBooks.getItems().clear();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Some of the books from your shopping cart have already been sold! Please go back to the shopping cart");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }

    }

}
