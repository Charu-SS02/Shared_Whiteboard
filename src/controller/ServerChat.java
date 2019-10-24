package controller;

import model.remote.IRemoteChatServer;
import model.server.RemoteChatServer;
import view.ChatPanel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerChat {

    public ServerChat(ChatPanel chatPanel, String ip, String port){
        IRemoteChatServer remoteChat;
        Registry registry;

        int portInt = Integer.parseInt(port);

        try {
            remoteChat = new RemoteChatServer(chatPanel);
            registry = LocateRegistry.getRegistry(ip, portInt);
            registry.bind("ChatMethod", remoteChat);
        }catch (Exception e){
            State.ShowErrors(e, "ServerChat - constructor");
        }
        State.Log("Chat Server ready");
    }

//    public ServerChat(ChatPanel chatPanel){
//        IRemoteChatServer remoteChat;
//        Registry registry;
//
//        try {
//            remoteChat = new RemoteChatServer(chatPanel);
//            registry = LocateRegistry.getRegistry();
//            registry.bind("ChatMethod", remoteChat);
//        }catch (Exception e){
//            State.ShowErrors(e, "ServerChat - constructor");
//        }
//        State.Log("Chat Server ready");
//    }
}
