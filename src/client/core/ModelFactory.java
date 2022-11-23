package client.core;

import client.model.UserModelManager;
import client.model.UserModelManagerImpl;

public class ModelFactory {

    private static ModelFactory instance = new ModelFactory();
    private UserModelManager userModelManager;

    public static ModelFactory getInstance() {
        return instance;
    }

    private ModelFactory() {

    }

    public UserModelManager getUserModelManager() {
        if (userModelManager == null) {
            userModelManager = new UserModelManagerImpl();
        }
        return userModelManager;
    }
}
