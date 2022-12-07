package client.views.seller.addBookForSaleView;

import client.core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddBookForSaleController {

    @FXML
    private TextField priceTextField;

    @FXML TextField conditionTextField;
    private AddBookForSaleViewModel addBookForSaleViewModel;
    public void init(AddBookForSaleViewModel addBookForSaleViewModel) {
        this.addBookForSaleViewModel = addBookForSaleViewModel;
        priceTextField.textProperty().bindBidirectional(addBookForSaleViewModel.priceProperty());
        conditionTextField.textProperty().bindBidirectional(addBookForSaleViewModel.conditionProperty());
    }

    public void onAddBook() {
        addBookForSaleViewModel.addBookForSale();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Book is now AVAILABLE for sale. :)");
        alert.show();
    }

    public void onBackButton() {
        ViewHandler.getInstance().openAddBook();
    }
}
