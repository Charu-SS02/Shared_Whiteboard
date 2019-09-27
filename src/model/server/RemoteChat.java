package model.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.remote.IRemoteChat;

public class RemoteChat extends UnicastRemoteObject implements IRemoteChat {

    public RemoteChat() throws RemoteException{

    }

    @Override
    public String sendMessage(String message) throws RemoteException {
        System.out.println("sendMessage method is called");

        return message;
    }

    @Override
    public String receiveMessage(String message) throws RemoteException {
        System.out.println("receiveMessage method is called");

        return message;
    }
}
