package model.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import controller.Tool;

public interface IRemoteDrawClient extends Remote {
	
    void Draw(Tool tool, Boolean complete,Boolean broadCast) throws RemoteException;
    void Sync(byte[] img) throws RemoteException;
}
