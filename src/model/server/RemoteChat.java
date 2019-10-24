package model.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controller.Message;
import model.remote.IRemoteChat;
import model.remote.IRemoteChatServer;
import view.ChatPanel;

public class RemoteChat extends UnicastRemoteObject implements IRemoteChat {

    private IRemoteChatServer chatServer;
    private String name = null;
    ChatPanel chatPanel;

    private static final long serialVersionUID = 3L;

    public RemoteChat() throws RemoteException{
        this.chatPanel = chatPanel;
    }

    @Override
    public void broadcastMessage(Message message, boolean broadcast) throws RemoteException{
        chatPanel.addMessage(message, broadcast);
    }
}
