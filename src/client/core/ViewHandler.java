package client.core;

import client.views.seller.addBooksView.AddBooksController;
import client.views.shared.createAccountView.CreateAccountViewController;
import client.views.shared.signView.SignViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{

  private static ViewHandler instance = new ViewHandler();
  public static ViewHandler getInstance(){return instance;}

  private Stage stage;
  private Scene signScene;
  private Scene createAccountScene;
  private Scene AddBookScene;


  public ViewHandler()
  {

  }

  public void start()
  {
    stage = new Stage();
    openSign();
  }

  public void openSign()
  {
    if (signScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("signView.fxml"));
        Parent root = loader.load();
        SignViewController signViewController = loader.getController();
        signViewController.init(this, ViewModelFactory.getInstance().getSignViewModel());
        stage.setTitle("Sign");
        signScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(signScene);
      stage.show();
    }
  }

  public void openCreateAccount()
  {
    if (createAccountScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("createAccountView.fxml"));
        Parent root = loader.load();
        CreateAccountViewController createAccountViewController = loader.getController();
        createAccountViewController.init(ViewModelFactory.getInstance().getCreateAccountViewModel());
        stage.setTitle("Create account");
        signScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(signScene);
      stage.show();
    }
  }

  public void openAddBook()
  {
    if (AddBookScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addBooks.fxml"));
        Parent root = loader.load();
        AddBooksController addBooksController = loader.getController();
        addBooksController.init( ViewModelFactory.getInstance().getAddBooksViewModel());
        stage.setTitle("Add Books");
        AddBookScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(AddBookScene);
      stage.show();
    }
  }



}





