package Main.Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ListenerSocket {

    private static String hostname = "127.0.0.1";
    private static int portnumber = 8080;

    public static void tryListen() {
        try {
            listen();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        }
    }

    private static void listen() throws IOException {

        final ServerSocket serverSocket = new ServerSocket(portnumber);
        System.out.println("Listening... ");

        while (true) {

            Socket clientSocket = serverSocket.accept();

            InputStreamReader isr
                    =  new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();

            while (!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
            }

            String today = "oiheoihgoihewgoihweogweohgehoiwgihoewgoihewgohiewghoiewghoiewghoiewohiwohiehogeighewoi";
            String httpResponse = "HTTP/1.1 308 Permanent Redirect\r\n\r\n" + today;
            clientSocket.getOutputStream()
                    .write(httpResponse.getBytes("UTF-8"));
        }
    }

    private String getFilepath(String string){

    return "hei";
    }
}
