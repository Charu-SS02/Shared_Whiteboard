package model.server;

import view.ChatPanel;
import controller.Message;
import model.remote.IRemoteChatClient;
import model.remote.IRemoteChatServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteChatClient extends UnicastRemoteObject implements IRemoteChatClient {

    private IRemoteChatServer chatServer;
    private String name = null;
    public ChatPanel chatPanel;

    public RemoteChatClient(String name, IRemoteChatServer chatServer, ChatPanel chatPanel) throws RemoteException{
        this.name = name;
        this.chatServer = chatServer;
        this.chatPanel = chatPanel;

        chatServer.registerChatClient(this);
    }

    @Override
    public void addMessage(Message message, boolean broadcast) throws RemoteException{
        chatPanel.addMessage(message, broadcast);
    }
}
