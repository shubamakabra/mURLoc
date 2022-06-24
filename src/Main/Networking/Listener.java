package Main.Networking;

import Main.Accounts.Users;
import com.sun.net.httpserver.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

public class Listener {

    private static String hostname = "127.0.0.1";
    private static int portnumber = 8080;
    private static Users users;


    public Listener(Users u){
        this.users = u;
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
        String c;

        //Here a redirect request is made for each user. This might not be nessecary, as it can be handled with just the "/" and then the handleRedirect is the one that either sends you to google, or the uglylink.

        for (String s : users.getKeys()){
            c = "/" + s;
            HttpContext mURLoc = server.createContext("/"+ s);
            mURLoc.setHandler(Listener::redirectRequest);
        }

        //For some reason, this is activated even if it doesnt match the context. Some more info about the HTTP functionalities is neccesary here.
        //HttpContext mURLoc = server.createContext("/");
        //mURLoc.setHandler(Listener::redirectRequest);

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
        location = location.replaceAll("/","");
        String link = "";
        boolean c = users.contains(location);

        System.out.println(c);

        if(c){
            link = users.getUglyURL(location).strip();
            System.out.println("Link found: " + link);
        }

        Headers responseHeaders = exchange.getResponseHeaders();

        if (link != null && link != ""){
            System.out.println("Link found! Redirecting you to http://localhost:8080/" + link);
            responseHeaders.set("Location", "http://localhost:8080/" + link);
        } else  {
            System.out.println("No mURLoc found!");
            responseHeaders.set("Location", "https://google.com");
        }
        exchange.sendResponseHeaders(302,0);
    }
}
