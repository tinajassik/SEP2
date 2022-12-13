package client.model;

import client.network.Client;
import shared.Buyer;
import shared.Seller;
import shared.User;
import util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;

public class AccountModelManagerImpl implements AccountModelManager
{
    // model responsible for logging in/creating account

    private Client client;

    private User user;

    public AccountModelManagerImpl(Client client)
    {
        this.client = client;
        client.startClient();
    }


    @Override
    public boolean registerBuyer(String fullName, String address, String phoneNumber, String email, String username, String password) {
        user = new Buyer(fullName,address,phoneNumber, email, username, password);
        return client.registerUser(user);

    }

    @Override
    public boolean registerSeller(String fullName, String address, String phoneNumber, String email, String username, String password) {
        user = new Seller(fullName,address,phoneNumber, email, username, password);
        return client.registerUser(user);
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public boolean validatePassword(String username, String password) {
        return client.checkPassword(username,password);
    }

    @Override
    public boolean validateUser(String username) {
        return client.checkUsername(username);
    }

    @Override
    public User getUserType(String username) {
        user = client.getUser(username);
        return user;
    }

}
