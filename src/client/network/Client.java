package client.network;

import shared.*;
import util.Subject;

import java.util.ArrayList;
import java.util.List;

public interface Client extends Subject
{
  void startClient();
  boolean checkUsername(String username);
  boolean registerUser(User user);
  boolean checkPassword(String username, String password);
  void AddBook(Book book);
  List<BookForSale> getBooks();
  ArrayList<Author> getAuthors();
  ArrayList<Genre> getGenres();
  User getUser(String username);
  User getUser();
  void addBookForSale(String condition,double price, Book book, User user);
  List<BookForSale> searchBooksByTitle(String title);
  ArrayList<Genre> getAllGenres();
  List<BookForSale> searchBooksByGenre(String genre);
  List<BookForSale> searchBooksByAuthor(String authorFName, String authorLName);
  List<BookForSale> getBooksSoldBy(String id);
  void editBook(String condition,double price, Book book, String username);

  void deleteBook(int id);
  void purchase(ArrayList<BookForSale> booksToBeSold);

}
