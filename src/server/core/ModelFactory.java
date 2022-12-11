package server.core;

import server.model.LogInModelManager;
import server.model.LogInModelManagerImpl;
import server.model.StoreModelManager;
import server.model.StoreModelManagerImpl;

import java.sql.SQLException;

public class ModelFactory {

    private static ModelFactory instance = new ModelFactory();

    public static ModelFactory getInstance() {
        return instance;
    }

    private LogInModelManager logInModelManager;
    private StoreModelManager storeModelManager;

    private ModelFactory() {

    }

    public LogInModelManager getLogInModelManager() {
        if (logInModelManager == null) {
            logInModelManager = new LogInModelManagerImpl();
        }
        return logInModelManager;
    }

    public StoreModelManager getStoreModelManager() {
        if (storeModelManager == null) {
            try {
                storeModelManager = new StoreModelManagerImpl();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return storeModelManager;
    }

}
