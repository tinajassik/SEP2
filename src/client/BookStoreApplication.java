package client;

import client.core.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class BookStoreApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewHandler viewHandler = new ViewHandler();
        viewHandler.start();
    }
}
