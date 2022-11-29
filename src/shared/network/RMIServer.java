package shared.network;

import util.User;

import java.rmi.Remote;

public interface RMIServer extends Remote
{
  void registerNewUser(User user);
  boolean isUsernameTaken(String username);
}
