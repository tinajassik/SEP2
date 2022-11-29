package client.network;

import client.model.User;
import util.Subject;

public interface Client extends Subject
{
  void startClient();
  boolean checkUsername(String username);
  void registerUser(User user);
}
