package client.network;

import util.User;
import shared.network.RMIClient;
import shared.network.RMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClientImpl implements Client, RMIClient
{

  private PropertyChangeSupport propertyChangeSupport;
  private RMIServer server;
  private Registry registry = null;

  public RMIClientImpl()
  {
    this.propertyChangeSupport = new PropertyChangeSupport(this);
    try
    {
      UnicastRemoteObject.exportObject(this,0);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void startClient()
  {

    try
    {
      registry = LocateRegistry.getRegistry("localhost",1099);

      server = (RMIServer) registry.lookup("Server");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void registerUser(User user)
  {
    server.registerNewUser(user);
  }

  @Override public boolean checkUsername(String username)
  {
    return server.isUsernameTaken(username);
  }

  @Override public void addPropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {

  }

  @Override public void removePropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {

  }
}
