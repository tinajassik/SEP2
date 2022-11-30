package server.network;

import server.database.book.AuthorDAOImpl;
import server.database.book.GenreDAOImpl;
import server.model.LogInModelManager;
import server.model.LogInModelManagerImpl;
import shared.Author;
import shared.Genre;
import shared.Seller;
import shared.User;
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
  public void AddBook() {

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
