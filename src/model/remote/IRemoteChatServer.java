package model.remote;

import controller.Message;
import controller.Tool;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteChatServer extends Remote{

//    void registerDrawClient(IRemoteDrawClient drawClient) throws RemoteException;
//    void Draw(Tool tool, Boolean complete, Boolean broadCast) throws RemoteException;

    public void registerChatClient(IRemoteChatClient chatClient) throws RemoteException;
    public void addMessage(Message message, boolean broadcast) throws RemoteException;
}
