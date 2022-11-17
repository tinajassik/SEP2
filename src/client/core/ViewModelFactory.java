package client.core;

import client.views.seller.addBooksView.AddBooksViewModel;
import client.views.shared.createAccountView.CreateAccountViewModel;
import client.views.shared.signView.SignViewModel;

import java.rmi.RemoteException;

public class ViewModelFactory {

  private static ViewModelFactory instance=new ViewModelFactory();

  public static ViewModelFactory getInstance(){
    return instance;
  }
  private SignViewModel signViewModel;
  private CreateAccountViewModel createAccountViewModel;

  private AddBooksViewModel addBooksViewModel;

  private ViewModelFactory() {
  }

  public SignViewModel getSignViewModel() throws RemoteException
  {
    if (signViewModel == null)
      signViewModel = new SignViewModel();
    return signViewModel;
  }

  public CreateAccountViewModel getCreateAccountViewModel() throws RemoteException
  {
    if (createAccountViewModel == null)
      createAccountViewModel = new CreateAccountViewModel();
    return createAccountViewModel;
  }

  public AddBooksViewModel getAddBooksViewModel() throws RemoteException
  {
    if (addBooksViewModel == null)
      addBooksViewModel = new AddBooksViewModel();
    return addBooksViewModel;
  }

}