package client.core;

import client.model.*;

public class ModelFactory {

    private static ModelFactory instance;
    private AccountModelManager accountModelManager;
    private SellerModelManager sellerModelManager;
    private BuyerModelManager buyerModelManager;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory() {

    }

    public AccountModelManager getUserModelManager() {
        if (accountModelManager == null) {
            accountModelManager = new AccountModelManagerImpl(ClientFactory.getInstance().getClient());
        }
        return accountModelManager;
    }

    public SellerModelManager getSellerModelManager() {
        if (sellerModelManager == null) {
            sellerModelManager = new SellerModelManagerImpl();
        }
        return sellerModelManager;
    }

    public BuyerModelManager getBuyerModelManager() {
        if (buyerModelManager == null) {
            buyerModelManager = new BuyerModelManagerImpl();
        }
        return buyerModelManager;
    }


}
