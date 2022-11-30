package shared.network;

import shared.Author;
import shared.Genre;
import shared.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIServer extends Remote
{
  boolean registerNewUser(User user) throws RemoteException;
  boolean isUsernameTaken(String username) throws RemoteException;

  boolean validatePassword(String username, String password) throws RemoteException;
  void AddBook() throws RemoteException;
  ArrayList<Author> getAuthors() throws RemoteException;
  ArrayList<Genre> getGenres() throws RemoteException;
}
