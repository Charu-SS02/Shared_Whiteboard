package model.client;

import model.remote.IRemoteChat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args){

        System.out.println("Client is starting...");

        try{
            Registry registry = LocateRegistry.getRegistry();

            IRemoteChat remoteChat = (IRemoteChat) registry.lookup("Chat");


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
