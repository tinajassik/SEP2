package client.seller.core;


import client.seller.views.addBooksView.AddBooksViewModel;

import java.rmi.RemoteException;

public class ViewModelFactory {

  private static ViewModelFactory instance=new ViewModelFactory();

  public static ViewModelFactory getInstance(){
    return instance;
  }
  private AddBooksViewModel addBooksViewModel;

  private ViewModelFactory() {
  }

  public AddBooksViewModel getSignViewModel() throws RemoteException
  {
    if (addBooksViewModel == null)
      addBooksViewModel = new AddBooksViewModel();
    return addBooksViewModel;
  }

}
