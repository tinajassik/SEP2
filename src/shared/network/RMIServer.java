package shared.network;

import shared.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface RMIServer extends Remote
{
  void registerClientCallback(ClientCallback clientCallback) throws RemoteException;
  void unregisterClientCallback(ClientCallback clientCallback) throws RemoteException;
  boolean registerNewUser(User user) throws RemoteException;
  boolean isUsernameTaken(String username) throws RemoteException;
  boolean validatePassword(String username, String password) throws RemoteException;
  void AddBook(Book book) throws RemoteException;
  List<BookForSale> getBooks() throws RemoteException;
  void addBookForSale(String condition, double price, Book book, User user) throws RemoteException;
  ArrayList<Author> getAuthors() throws RemoteException;
  ArrayList<Genre> getGenres() throws RemoteException;
  User getUser(String username) throws RemoteException;

  List<BookForSale> getBooksByTitle(String title) throws RemoteException;
  List<BookForSale> getBooksByGenre(String genre) throws RemoteException;
  List<BookForSale> getBooksByAuthor(String authorFName, String authorLName) throws RemoteException;

  List<BookForSale> getBooksSoldBy(String id) throws RemoteException;

  void editBook(String condition, double price, Book book, String username) throws RemoteException;
  void deleteBook(int id) throws RemoteException;

}
