package client.model;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;

public class UserModelManagerImpl implements UserModelManager {

    private HashMap<String, User> allRegisteredUsers = new HashMap<>();
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    @Override
    public void registerBuyer(String fullName, String address, String phoneNumber, String email, String username, String password) {
        allRegisteredUsers.put(username,new Buyer(fullName, address, phoneNumber, email, username, password)) ;
    }

    @Override
    public void registerSeller(String fullName, String address, String phoneNumber, String email, String username, String password) {
        allRegisteredUsers.put(username,new Seller(fullName, address, phoneNumber, email, username, password)) ;
    }

    @Override
    public User getUser(String username) {
        return allRegisteredUsers.get(username);
    }

    @Override
    public boolean validatePassword(String username, String password) {
        User user = allRegisteredUsers.get(username);
        String correctPassword = user.getPassword();
        return correctPassword.equals(password);
    }

    @Override
    public boolean validateUser(String username) {
        return allRegisteredUsers.containsKey(username);
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
