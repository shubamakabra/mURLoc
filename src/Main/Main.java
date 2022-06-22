package Main;

import Main.Networking.Listener;
import Main.Networking.ListenerSocket;

public class Main {

    public static void main(String[] args) {

        Listener listener = new Listener();
        listener.tryListen();

    }



}
