package client.network;

import shared.*;
import shared.network.RMIClient;
import shared.network.RMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIClientImpl implements Client, RMIClient {

  private PropertyChangeSupport propertyChangeSupport;
  private RMIServer server;
  private Registry registry = null;

  public RMIClientImpl() {
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
    } catch (RemoteException | NotBoundException e) {
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
      server.AddBook(book);
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
  public boolean checkUsername(String username) {
    try {
      return server.isUsernameTaken(username);
    } catch (RemoteException e) {
      throw new RuntimeException("Trouble connecting to the server");
    }
  }

  @Override
  public void addPropertyChangeListener(String eventName,
                                        PropertyChangeListener listener) {

  }

  @Override
  public void removePropertyChangeListener(String eventName,
                                           PropertyChangeListener listener) {

  }

  public RMIServer getServer() {
    return server;
  }
}
