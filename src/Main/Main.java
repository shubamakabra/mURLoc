package Main;

import Main.Accounts.Registration;
import Main.Accounts.Users;
import Main.Networking.Listener;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int runMode = 0;
        Users users = new Users();

        if (users.empty()){
            runMode = 1;
            System.out.println("No users found! Entering registration mode: ");
        }
        //Default mode where the program listens to incomming requests.
        if (runMode == 0){
            Listener listener = new Listener(users);
            listener.tryListen();

        //This mode is for devs to register users.
        } else if(runMode == 1){

            System.out.println("Entering User Registration: ");
            Registration.registrating(users);
        }
    }
}
