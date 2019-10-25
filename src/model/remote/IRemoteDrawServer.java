package model.remote;

import java.awt.image.BufferedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;

import controller.Message;
import controller.Tool;

public interface IRemoteDrawServer extends Remote{
	
	void registerDrawClient(IRemoteDrawClient drawClient,String uname) throws RemoteException;
    void Draw(Tool tool, Boolean complete,Boolean broadCast) throws RemoteException;
    void Sync(byte[] img, Boolean broadcast) throws RemoteException;
	void RequestSync(Boolean broadCast) throws RemoteException;
	void addMessage(Message message, boolean broadcast) throws RemoteException;
}
