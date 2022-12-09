package client.views.seller.addBookForSaleView;

import client.core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

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

        if (AreWeAllInThisTogetherPartTwo()) {

            addBookForSaleViewModel.addBookForSale();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Book is now AVAILABLE for sale. :)");
            alert.show();
            }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Faulty book information");
            alert.setContentText("Make sure no fields are empty \n and price does not contain letters");
            alert.show();
        }



    }

    public void onBackButton() {
        ViewHandler.getInstance().openAddBook();
    }

    public boolean AreWeAllInThisTogetherPartTwo(){

        if (priceTextField.getText().isEmpty() || conditionTextField.getText().isEmpty() || (!priceTextField.getText().matches("[0-9]+"))){

            return false;
        }
        else return true;

    }
}
