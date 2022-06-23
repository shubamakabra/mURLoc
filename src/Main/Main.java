package Main;

import Main.Accounts.Registration;
import Main.Accounts.User;
import Main.Accounts.Users;
import Main.Networking.Listener;
import Main.Networking.URLholder;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        int runMode = 1;
        Users users = new Users();

        if (runMode == 0){

            HashMap<User, URLholder> map = new HashMap<User,URLholder>();
            //HashTable ht = new HashTable(10000000);

            Listener listener = new Listener(map);
            listener.tryListen();

        } else if(runMode == 1){
            System.out.println("Entering User Registration: ");
            Registration.registrating(users);

            //Here will be for registration of customers.
        }


    }



}
