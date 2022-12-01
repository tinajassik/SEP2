package client.core;

import client.model.*;

public class ModelFactory {

    private static ModelFactory instance = new ModelFactory();
    private UserModelManager userModelManager;
    private SellerModelManager sellerModelManager;

    private BuyerModelManager buyerModelManager;

    public static ModelFactory getInstance() {
        return instance;
    }

    private ModelFactory() {

    }

    public UserModelManager getUserModelManager() {
        if (userModelManager == null) {
            userModelManager = new UserModelManagerImpl(ClientFactory.getInstance().getClient());
        }
        return userModelManager;
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
