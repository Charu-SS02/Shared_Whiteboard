package model.remote;

import java.awt.image.BufferedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;

import controller.Tool;

public interface IRemoteDrawServer extends Remote{
	
	void registerDrawClient(IRemoteDrawClient drawClient) throws RemoteException;
    void Draw(Tool tool, Boolean complete,Boolean broadCast) throws RemoteException;
    void Sync(byte[] img, Boolean broadcast) throws RemoteException;
}
