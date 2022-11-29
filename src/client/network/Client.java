package client.network;

import util.User;
import util.Subject;

public interface Client extends Subject
{
  void startClient();
  boolean checkUsername(String username);
  void registerUser(User user);
}
