package controller;

import model.remote.IRemoteChatServer;
import model.server.RemoteChatServer;
import view.ChatPanel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerChat {

    public ServerChat(ChatPanel chatPanel){
        IRemoteChatServer remoteChat;
        Registry registry;

        try {
            remoteChat = new RemoteChatServer(chatPanel);
            registry = LocateRegistry.getRegistry();
            registry.bind("ChatMethod", remoteChat);
        }catch (Exception e){
            State.ErrorLog(e.getMessage());
            State.ErrorLog(e.getStackTrace().toString());
        }
        State.Log("Chat Server ready");
    }
}
