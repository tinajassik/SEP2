package client;

import client.core.ViewHandler;
import client.network.Client;
import client.network.RMIClientImpl;
import javafx.application.Application;
import javafx.stage.Stage;

public class BookStoreApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewHandler.getInstance().start();

    }
}
