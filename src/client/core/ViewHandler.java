package client.core;

import client.views.buyer.bookDetails.BookDetailsController;
import client.views.buyer.mainPageView.MainPageController;
import client.views.buyer.shoppingCartView.ShoppingCartController;
import client.views.seller.addBookForSaleView.AddBookForSaleController;
import client.views.seller.addBooksView.AddBooksController;
import client.views.seller.bookDetails.BookDetailsSellerController;
import client.views.seller.mainPage.MainPageSellerController;
import client.views.shared.createAccountView.CreateAccountViewController;
import client.views.shared.signView.SignViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private static ViewHandler instance = new ViewHandler();
    private Stage stage;
    private BookDetailsController bookDetailsController;
    private MainPageController mainPageController;

    private MainPageSellerController mainPageSellerController;

    public static ViewHandler getInstance(){
        return instance;
    }

    private ViewHandler()
    {
        stage = new Stage();
    }

    public void start()
    {
        instance.openSign();
    }

    public void openSign() {

        Scene scene = null;

        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/shared/signView/signView.fxml"));
            Parent root = loader.load();
            SignViewController signViewController = loader.getController();
            signViewController.init(this, ViewModelFactory.getInstance().getSignViewModel());
            stage.setTitle("Sign");
            scene = new Scene(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }

    public void openCreateAccount()
    {
        Scene scene = null;
        try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../views/shared/createAccountView/createAccountView.fxml"));
                Parent root = loader.load();
                CreateAccountViewController createAccountViewController = loader.getController();
                createAccountViewController.init(ViewModelFactory.getInstance().getCreateAccountViewModel());
                stage.setTitle("Create account");
                scene = new Scene(root);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            stage.setScene(scene);
            stage.show();
        }


    public void openAddBook()
    {
        Scene scene = null;
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../views/seller/addBooksView/addBooks.fxml"));
                Parent root = loader.load();
                AddBooksController addBooksController = loader.getController();
                addBooksController.init( ViewModelFactory.getInstance().getAddBooksViewModel());
                stage.setTitle("Add Books");
                scene = new Scene(root);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            stage.setScene(scene);
            stage.show();

    }

    public void openMainViewBuyers() {
       Scene scene= null;
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../views/buyer/mainPageView/mainpage.fxml"));
                Parent root = loader.load();
                 mainPageController = loader.getController();
                 mainPageController.init(ViewModelFactory.getInstance().getMainPageBuyersViewModel());
                stage.setTitle("Main Page");
                scene = new Scene(root);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            stage.setScene(scene);
            stage.show();
        }

        public void openMainViewSellers() {
            Scene scene= null;
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../views/seller/mainPage/mainpage.fxml"));
                Parent root = loader.load();
                mainPageSellerController = loader.getController();
                mainPageSellerController.init(this,ViewModelFactory.getInstance().getMainPageSellersViewModel());
                stage.setTitle("Main Page");
                scene = new Scene(root);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            stage.setScene(scene);
            stage.show();
        }

    public void openAddBookForSaleView() {
        Scene scene= null;
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/seller/addBookForSaleView/addbookforsale.fxml"));
            Parent root = loader.load();
            AddBookForSaleController addBookForSaleController = loader.getController();
            addBookForSaleController.init(ViewModelFactory.getInstance().getAddBookForSaleViewModel());
            stage.setTitle("Add Book For Sale");
            scene = new Scene(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }


    public void openShoppingCart() {
        Scene scene= null;
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/buyer/shoppingCart/shoppingCart.fxml"));
            Parent root = loader.load();
            ShoppingCartController shoppingCartController = loader.getController();
            shoppingCartController.init(ViewModelFactory.getInstance().getShoppingCartViewModel());
            stage.setTitle("Shopping Cart");
            scene = new Scene(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }

    public void openBookDetails() {
        Scene scene= null;
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/buyer/bookDetails/bookdetails.fxml"));
            Parent root = loader.load();
            this.bookDetailsController = loader.getController();
            this.bookDetailsController.init(ViewModelFactory.getInstance().getBookDetailsViewModel());
            stage.setTitle("Shopping Cart");
            scene = new Scene(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }

    public MainPageController getMainPageController(){
        return mainPageController;
    }


    public void openBookDetailsSeller() {
        Scene scene= null;
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/seller/bookDetails/bookdetails.fxml"));
            Parent root = loader.load();
            BookDetailsSellerController bookDetailsController = loader.getController();
            bookDetailsController.init(ViewModelFactory.getInstance().getBookDetailsSellerViewModel());
            stage.setTitle("BookDetails - SELLER");
            scene = new Scene(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }


    public MainPageSellerController getMainPageSellerController() {
        return mainPageSellerController;
    }





}
