package Main.Networking;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Listener {

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

        HttpServer server = HttpServer.create(new InetSocketAddress(portnumber), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(Listener::handleRequest);

        HttpContext mURLoc = server.createContext("/mURLoc/");
        mURLoc.setHandler(Listener::redirectRequest);

        server.start();
        System.out.println("Listening... ");
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String response = "Hi there!";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private static void redirectRequest(HttpExchange exchange) throws IOException {
        //String location = db.getURL(mURLoc);
        String location;
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("Location", "https://google.com");
        exchange.sendResponseHeaders(302,0);
    }

    private String getFilepath(String string){

        return "hei";
    }
}
