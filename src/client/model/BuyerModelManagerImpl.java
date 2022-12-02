package client.model;

import client.core.ClientFactory;
import client.network.Client;
import shared.BookForSale;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class BuyerModelManagerImpl implements BuyerModelManager {

    private Client client;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public BuyerModelManagerImpl() {
        client = ClientFactory.getInstance().getClient();
        client.addPropertyChangeListener("NewBookForSale", this::onNewBookForSale);
    }

    private void onNewBookForSale(PropertyChangeEvent evt) {
        System.out.println(evt.getNewValue().toString());
        System.out.println("observer in buyer model manager");
        support.firePropertyChange(evt);

    }

    public List<BookForSale> getBooks() {
         return client.getBooks();
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }
}
