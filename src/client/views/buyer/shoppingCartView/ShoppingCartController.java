package client.views.buyer.shoppingCartView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.buyer.mainPageView.MainPageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import shared.BookForSale;

import java.util.ArrayList;

public class ShoppingCartController {


    private MainPageViewModel mainPageViewModel;
    @FXML
    public ListView listViewBooksToBuy;
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
        labelUsername.textProperty().bindBidirectional(shoppingCartViewModel.getUsernameProperty());
        labelFullName.textProperty().bindBidirectional(shoppingCartViewModel.getFullNameProperty());
        labelPrice.textProperty().bindBidirectional(shoppingCartViewModel.getPriceProperty());
        shoppingCartViewModel.setPrice();
        shoppingCartViewModel.loadBooksForSale();
        listViewBooksToBuy.setItems(shoppingCartViewModel.getShoppingCartObservableList());
//        loadShoppingCart();
    }

//    public void loadShoppingCart()
//    {
//        ArrayList<BookForSale> shoppingCart = shoppingCartViewModel.getShoppingCart();
//        for (BookForSale book:shoppingCart )
//        {
//            if (!shoppingCartViewModel.getAvailableBooks().contains(book)) {
//                shoppingCart.remove(book);
//            }
//            listViewBooksToBuy.getItems().add(book);
//        }
//    }

    @FXML
    public void onSignOut(ActionEvent actionEvent) {
        ViewHandler.getInstance().openSign();
    }

    @FXML
    public void onCheckOut(ActionEvent actionEvent)
    {
        if (!shoppingCartViewModel.getShoppingCart().isEmpty())
        {
            ViewHandler.getInstance().openCheckOut();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("The cart is empty");
            alert.show();

        }

    }

    @FXML
    public void onBackToMainPage(ActionEvent actionEvent)
    {
        ViewHandler.getInstance().openMainViewBuyers();
    }

    public void onRemoveItem(ActionEvent actionEvent)
    {
        if (!shoppingCartViewModel.getShoppingCart().isEmpty() && !listViewBooksToBuy.getSelectionModel().isEmpty())
        {
            BookForSale bookToRemove = (BookForSale) listViewBooksToBuy.getSelectionModel().getSelectedItem();
            shoppingCartViewModel.removeFromShoppingCart(bookToRemove);
            shoppingCartViewModel.loadBooksForSale();
            listViewBooksToBuy.setItems(shoppingCartViewModel.getShoppingCartObservableList());
            shoppingCartViewModel.setPrice();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("The cart is empty/You have not selected any book");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
    }
}
