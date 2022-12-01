package client.model;

import client.network.Client;
import shared.Buyer;
import shared.Seller;
import shared.User;
import util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;

public class UserModelManagerImpl implements UserModelManager, Subject
{

    private HashMap<String, User> allRegisteredUsers = new HashMap<>();

    private PropertyChangeSupport propertyChangeSupport ;

    private Client client;

    private User user;

    public UserModelManagerImpl(Client client)
    {
        this.client = client;
        client.startClient();
        propertyChangeSupport = new PropertyChangeSupport(this);
    }


    @Override
    public boolean registerBuyer(String fullName, String address, String phoneNumber, String email, String username, String password) {
        this.user = new Buyer(fullName,address,phoneNumber, email, username, password);
        return client.registerUser(user);
    }

    @Override
    public boolean registerSeller(String fullName, String address, String phoneNumber, String email, String username, String password) {
        this.user = new Seller(fullName,address,phoneNumber, email, username, password);
//        client.startClient();
        System.out.println("in user model manager - client side");
       return client.registerUser(user);
    }

    @Override
    public User getUserType(String username) {
        user = client.getUser(username);
        return user;
    }

    @Override public User getUser()
    {
        return user;
    }

    @Override
    public boolean validatePassword(String username, String password) throws IllegalAccessException {
        return client.checkPassword(username,password);
    }

    @Override
    public boolean validateUser(String username) {
        return client.checkUsername(username);
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(eventName,listener);
    }
}
