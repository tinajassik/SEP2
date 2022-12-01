package server.network;

import server.database.book.AuthorDAOImpl;
import server.database.book.BookDAO;
import server.database.book.BookDAOImpl;
import server.database.book.GenreDAOImpl;
import server.model.LogInModelManager;
import server.model.LogInModelManagerImpl;
import shared.*;
import shared.network.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class RMIServerImpl implements Remote, RMIServer

{
  private LogInModelManager logInModelManager;
  public RMIServerImpl()
  {
    logInModelManager = new LogInModelManagerImpl();
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
    BookDAO bookDAO= null;

    try {
      bookDAO = BookDAOImpl.getInstance();
      if (bookDAO.readByISBN(book.getIsbn()) == null) {
        bookDAO.create(book.getIsbn(),book.getTitle(),book.getCoverType(), book.getAuthor(), book.getYearOfPublish(), book.getGenre());
      }
      else {
        //do nothing, because the book is already in the database
        // and we do not need to crate another one
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public ArrayList<Author> getAuthors() {
    try {
      return (ArrayList<Author>)AuthorDAOImpl.getInstance().getAllAuthors();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ArrayList<Genre> getGenres() {
    try {
      return (ArrayList<Genre>) GenreDAOImpl.getInstance().getAllGenres();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
