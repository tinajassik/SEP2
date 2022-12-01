package server.model;

import shared.User;

import java.rmi.RemoteException;

public interface LogInModelManager {

    boolean validateUsername(String username) ;
    boolean validatePassword(String username, String password) ;
    boolean registerBuyer(User user) ;
    boolean registerSeller(User user);
    User getUser(String username);
}
