package Main;

import Main.Accounts.Registration;
import Main.Accounts.Users;
import Main.Accounts.login;
import Main.Networking.Listener;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int runMode = 0; //Change this to change runMode.
        Users users = new Users();

        //If there are no users, go into registration mode.
        if (users.empty()){
            runMode = 1;
        }

        //Default mode where the program listens to incomming requests.
        if (runMode == 0){
            Listener listener = new Listener(users);
            listener.tryListen();

        //This mode is for devs to register users.
        } else if(runMode == 1){

            System.out.println("Entering User Registration: ");
            Registration.registrating(users);

        } else if (runMode ==2){ //This mode is not completed.
            login.logIn(users);
    }
    }
}
