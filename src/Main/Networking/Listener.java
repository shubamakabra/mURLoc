package Main.Networking;

import Main.Accounts.User;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashMap;

public class Listener {

    private static String hostname = "127.0.0.1";
    private static int portnumber = 8080;
    private User user;
    private HashMap<String, User> map;


    public Listener(HashMap HT){
        //this.map = HT;
    }

    public void tryListen() {
        try {
            listen();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void listen() throws IOException{

        HttpServer server = HttpServer.create(new InetSocketAddress(portnumber), 0);


        //HttpContext context = server.createContext("/");
        //context.setHandler(Listener::handleRequest);

        HttpContext mURLoc = server.createContext("/");
        mURLoc.setHandler(Listener::redirectRequest);

        server.start();
        System.out.println("Listening... ");
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String response = "Welcome! Please register a mini-URL by emailing owner of http://localhost:8080/";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private static void redirectRequest(HttpExchange exchange) throws IOException {
        System.out.println("Redirect request recieved!");

        URI requestURI = exchange.getRequestURI();
        String location = (String) "" + requestURI;

        String response = null;

        System.out.println("Link found: " + response);



        Headers responseHeaders = exchange.getResponseHeaders();

        if (response != null){
            System.out.println("Link found! Redirecting...");
            responseHeaders.set("Location", "http://localhost:8080/" + response);
        } else {
            System.out.println("No mURLoc found!");
            responseHeaders.set("Location", "https://google.com");
        }
        exchange.sendResponseHeaders(302,0);
    }
}
