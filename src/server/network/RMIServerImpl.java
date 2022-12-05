package server.network;

import server.core.ModelFactory;
import server.database.book.*;
import server.model.LogInModelManager;
import server.model.StoreModelManager;
import shared.*;
import shared.network.ClientCallback;
import shared.network.RMIServer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RMIServerImpl implements Remote, RMIServer

{
  private LogInModelManager logInModelManager;
  private StoreModelManager storeModelManager;

  private Map<ClientCallback, PropertyChangeListener> listeners = new HashMap<>();

  public RMIServerImpl()
  {
    logInModelManager = ModelFactory.getInstance().getLogInModelManager();
    storeModelManager = ModelFactory.getInstance().getStoreModelManager();
    try
    {
      UnicastRemoteObject.exportObject(this,0);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  public void startServer()
  {
    Registry registry = null;
    try
    {
      registry = LocateRegistry.createRegistry(1992);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    try
    {
      registry.bind("Server", this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    catch (AlreadyBoundException e)
    {
      e.printStackTrace();
    }

  }

  public void registerClientCallback(ClientCallback clientCallback) {
    PropertyChangeListener listener = new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {

        try {
          clientCallback.update((BookForSale) evt.getNewValue());
          System.out.println("in registerclientcallback method");
        } catch (RemoteException e) {
          throw new RuntimeException(e);
        }
        storeModelManager.removePropertyChangeListener("NewBookForSale", this);

      }
    };
    listeners.put(clientCallback, listener);
    System.out.println(listeners.toString());
    storeModelManager.addPropertyChangeListener("NewBookForSale", listener);
  }

  @Override
  public void unregisterClientCallback(ClientCallback client) {
    PropertyChangeListener listener = listeners.get(client);
    if(listener != null) {
      storeModelManager.removePropertyChangeListener("NewBookForSale", listener);
    }

  }




  @Override
  public boolean registerNewUser(User user) {
    if (user instanceof Seller)  {
      System.out.println("in server");
      return logInModelManager.registerSeller(user);
    }
    else return logInModelManager.registerBuyer(user);

  }

  @Override
  public boolean isUsernameTaken(String username)  {
    return logInModelManager.validateUsername(username);
  }

  @Override
  public boolean validatePassword(String username, String password) {
    return logInModelManager.validatePassword(username, password);
  }

  @Override
  public void AddBook(Book book) {
    System.out.println("RMI SERVER");
    storeModelManager.AddBook(book);
  }

  @Override
  public List<BookForSale> getBooks() {
    return storeModelManager.getBooks();
  }

  @Override
  public void addBookForSale(String condition, double price, Book book, User user) {
    storeModelManager.addBookForSale(condition, price, book, user);
  }

  @Override
  public ArrayList<Author> getAuthors() {
      return storeModelManager.getAllAuthors();
  }

  @Override
  public ArrayList<Genre> getGenres() {
   return storeModelManager.getAllGenres();
  }

  @Override
  public User getUser(String username) throws RemoteException {
    return logInModelManager.getUser(username);
  }

  @Override public List<BookForSale> getBooksByTitle(String title) throws RemoteException
  {
    return storeModelManager.getBooksByTile(title);
  }

  @Override public List<BookForSale> getBooksByGenre(String genre)
      throws RemoteException
  {
    return storeModelManager.getBooksByGenre(genre);
  }

  @Override public List<BookForSale> getBooksByAuthor(String authorFName, String authorLName)
      throws RemoteException
  {
    return storeModelManager.getBookByAuthor(authorFName, authorLName);
  }
}
