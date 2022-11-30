package client.network;

import shared.Author;
import shared.Genre;
import shared.User;
import util.Subject;

import java.util.ArrayList;

public interface Client extends Subject
{
  void startClient();
  boolean checkUsername(String username);
  boolean registerUser(User user);
  boolean checkPassword(String username, String password);
  void AddBook();
  ArrayList<Author> getAuthors();
  ArrayList<Genre> getGenres();
}
