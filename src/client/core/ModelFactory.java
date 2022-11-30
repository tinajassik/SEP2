package client.core;

import client.model.SellerModelManager;
import client.model.SellerModelManagerImpl;
import client.model.UserModelManager;
import client.model.UserModelManagerImpl;

public class ModelFactory {

    private static ModelFactory instance = new ModelFactory();
    private UserModelManager userModelManager;
    private SellerModelManager sellerModelManager;

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


}
