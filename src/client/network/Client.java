package client.network;

import shared.User;
import util.Subject;

public interface Client extends Subject
{
  void startClient();
  boolean checkUsername(String username);
  boolean registerUser(User user);
  boolean checkPassword(String username, String password) throws IllegalAccessException;
  User getUser(String username);
}
