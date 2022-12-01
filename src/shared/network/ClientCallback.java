package shared.network;

import shared.BookForSale;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
    void update(BookForSale bookForSale) throws RemoteException;
}
