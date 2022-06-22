package Main.Networking;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public void tryListen() {
        try {
            listen();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void listen() throws IOException {

        final ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Listening... ");

        while(true){

        }
    }
}
