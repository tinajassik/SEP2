package shared.network;

import shared.BookForSale;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
    void updateNewBook(BookForSale bookForSale) throws RemoteException;
    void updateDeletedBook(BookForSale bookForSale) throws RemoteException;

}
