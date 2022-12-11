package client.views.seller.addBookForSaleView;

import client.core.ModelFactory;
import client.model.SellerModelManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddBookForSaleViewModel {
    private StringProperty condition, price;
    private SellerModelManager sellerModelManager;

    public AddBookForSaleViewModel() {
        condition = new SimpleStringProperty();
        price = new SimpleStringProperty();
        sellerModelManager = ModelFactory.getInstance().getSellerModelManager();
    }

    public StringProperty conditionProperty() {
        return condition;
    }
    public StringProperty priceProperty() {
        return price;
    }

    public void addBookForSale() {
        sellerModelManager.addBookForSale(Double.parseDouble(price.get()),condition.get());
    }

    public boolean validateInput() {
        if (price.getValue() == null || condition.getValue() == null){
            return false;

        }

        else if (price.getValue().isEmpty() || condition.getValue().isEmpty() || (!price.getValue().matches("[0-9]+"))){

            return false;
        }
        else return true;
    }
}

