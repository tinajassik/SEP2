package client.seller.core;

import client.seller.views.addBooksView.AddBooksController;
import client.seller.views.addBooksView.AddBooksViewModel;
import client.shared.core.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{

  private static ViewHandler instance = new ViewHandler(ViewModelFactory.getInstance());
  public static ViewHandler getInstance(){return instance;}

  private Stage stage;
  private Scene AddBookScene;
  private ViewModelFactory viewModelFactory;
  private AddBooksViewModel addBooksViewModel;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {
    stage = new Stage();
    openAddBook();
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
        addBooksController.init(this, addBooksViewModel);
        stage.setTitle("Sign");
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














