package client.model;

import client.core.ClientFactory;
import client.network.Client;
import client.network.RMIClientImpl;
import shared.Author;
import shared.Genre;

import java.util.ArrayList;

public class SellerModelManagerImpl implements SellerModelManager {

   private Client client;
    public SellerModelManagerImpl() {
        client = ClientFactory.getInstance().getClient();
    }

    @Override
    public void AddBook() {

    }

    @Override
    public ArrayList<Author> getAuthors() {
        return client.getAuthors();
    }

    @Override
    public ArrayList<Genre> getGenres() {
        return client.getGenres();
    }
}
