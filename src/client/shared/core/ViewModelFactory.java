package client.shared.core;

import client.shared.view.createAccountView.CreateAccountViewModel;
import client.shared.view.signView.SignViewModel;

import java.rmi.RemoteException;

public class ViewModelFactory {

  private static ViewModelFactory instance=new ViewModelFactory();

  public static ViewModelFactory getInstance(){
    return instance;
  }
  private SignViewModel signViewModel;
  private CreateAccountViewModel createAccountViewModel;

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

}
