package model.remote;

import controller.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteChatClient extends Remote {
    public void addMessage(Message message, boolean broadcast) throws RemoteException;
}
