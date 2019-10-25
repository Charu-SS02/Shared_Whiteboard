package model.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import controller.Message;

public interface IRemoteChat extends Remote {

    public void broadcastMessage(Message message, boolean broadcast) throws RemoteException;

}
