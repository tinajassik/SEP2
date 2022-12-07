package client.network;

import shared.*;
import shared.network.ClientCallback;
import shared.network.RMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class RMIClientImpl implements Client, ClientCallback
{

  private PropertyChangeSupport propertyChangeSupport;
  private RMIServer server;
  private Registry registry = null;

  private User user;

  public RMIClientImpl()
  {

    this.propertyChangeSupport = new PropertyChangeSupport(this);
    try {
      UnicastRemoteObject.exportObject(this, 0);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void startClient() {
    try {
      registry = LocateRegistry.getRegistry("localhost", 1992);
      server = (RMIServer) registry.lookup("Server");

        server.registerClientCallbackUpdate(this);
        server.registerClientCallbackDelete(this);

    }
    catch (RemoteException | NotBoundException e)
    {

      System.out.println("Server not found");
    }
  }

  @Override
  public boolean registerUser(User user) {
    try {
      System.out.println("in RMI CLient");
      System.out.println((user instanceof Seller) + " is seller boolean");
      return server.registerNewUser(user);
    } catch (RemoteException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean checkPassword(String username, String password) {
    try {
      return server.validatePassword(username, password);
    } catch (RemoteException e) {
      throw new RuntimeException("Trouble connecting to the server");
    }
  }

  @Override
  public void AddBook(Book book) {

    try {
      System.out.println("RMI CLIENT");
      System.out.println(book.getIsbn());
      server.AddBook(book);
    } catch (RemoteException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public List<BookForSale> getBooks() {
    try {
      return server.getBooks();
    } catch (RemoteException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ArrayList<Author> getAuthors() {
    try {
      return server.getAuthors();
    } catch (RemoteException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ArrayList<Genre> getGenres() {
    try {
      return server.getGenres();
    } catch (RemoteException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public User getUser(String username) {
    try {
      user = server.getUser(username);
      return user;
    } catch (RemoteException e) {
      throw new RuntimeException(e);
    }
  }
  @Override public User getUser()
  {
    return user;
  }


  @Override
  public void addBookForSale(String condition, double price, Book book, User user) {
    try {
      server.addBookForSale(condition, price, book, user);
    } catch (RemoteException e) {
      throw new RuntimeException(e);
    }
  }


  @Override public List<BookForSale> searchBooksByTitle(String title)
  {
    try
    {
      return server.getBooksByTitle(title);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override public ArrayList<Genre> getAllGenres()
  {
    try
    {
      return server.getGenres();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override public List<BookForSale> searchBooksByGenre(String genre)
  {
    try
    {
      return server.getBooksByGenre(genre);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override public List<BookForSale> searchBooksByAuthor(String authorFName, String authorLName)
  {
    try
    {
      return server.getBooksByAuthor(authorFName, authorLName);
    }
    catch (RemoteException e)
    {
     throw new RuntimeException(e);
    }
  }

  @Override
  public List<BookForSale> getBooksSoldBy(String id) {
    try {
      return server.getBooksSoldBy(id);
    } catch (RemoteException e) {

      throw new RuntimeException(e);
    }
  }

  @Override
  public void editBook(String condition, double price, Book book, String username) {
    try {
      server.editBook(condition, price, book, username);
    } catch (RemoteException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void deleteBook(int id) {
    try {
      server.deleteBook(id);
    } catch (RemoteException e) {
      throw new RuntimeException(e);
    }
  }


  @Override public boolean checkUsername(String username)  {
    try {
      return server.isUsernameTaken(username);
    } catch (RemoteException e) {
      throw new RuntimeException("Trouble connecting to the server");
    }
  }


  @Override public void addPropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removePropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(eventName,listener);

  }

  public RMIServer getServer() {
    return server;
  }

  @Override
  public void update(BookForSale bookForSale) {
    System.out.println("in update method");
    propertyChangeSupport.firePropertyChange("NewBookForSale", null, bookForSale);
  }

  @Override
  public void delete(BookForSale bookForSale) throws RemoteException {
    System.out.println("in delete method");
    propertyChangeSupport.firePropertyChange("BookForSaleDeleted", null, bookForSale);
  }
}
