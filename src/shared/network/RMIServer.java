package shared.network;

import shared.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  boolean registerNewUser(User user) throws RemoteException;
  boolean isUsernameTaken(String username) throws RemoteException;

  boolean validatePassword(String username, String password) throws RemoteException;
}
