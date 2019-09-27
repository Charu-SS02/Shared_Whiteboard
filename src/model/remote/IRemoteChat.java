package model.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteChat extends Remote {

    public String sendMessage(String message) throws RemoteException;

    public String receiveMessage(String message) throws RemoteException;

}
