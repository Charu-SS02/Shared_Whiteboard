package model.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteUser extends Remote {

    public void login(String username, String password) throws RemoteException;

    public void logout(String username) throws RemoteException;
}
