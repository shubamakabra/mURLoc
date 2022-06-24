package Main.Accounts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

//This function is the start of an account manager. It is not completed, but has some functionalities.
//It is possible to log in successfully, but not to change anything.
public class login {

    public static void logIn(Users u) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        User user;
        String name = "";
        String passhash = "";
        String uglyLink = "";
        String flair = "";

        int step = 0; //These steps are to determine which step in the login process the user is in. 0 means no username has been given, 1 means no password has been given, and 2 means that login was successful.
        boolean log = true;
        boolean change = true;
        while(log) {

            if(step < 1){
                System.out.println("Welcome to login!\nPlease enter username");
                name = String.valueOf((reader.readLine()));
            }

            if (u.hasUser(name) && step == 0){
                System.out.println("Welcome " + name + "!");
                step++;
            } else if (step == 0){
                System.out.println("No user was found by that name.");
            }

            if (step == 1){
                System.out.println("Please input password: ");
                passhash = String.valueOf(Math.abs((reader.readLine()).hashCode()));
            }

            //Checks both name, and the password hash for that name.
            if (u.userHasPasshash(name, passhash) && step == 2){
                System.out.println("Correct password input!");
                step++;

            } else if (step == 2){
                System.out.println("Incorrect password.");
            }

            if (step==3){

                System.out.println("Please select field to change:\n - 1 for name (and link) change.\n - 2 for password (and link) change.\n - 3 for link change.\n  - 4 for exit.");
                String input = String.valueOf((reader.readLine())).strip();

                //Now for what to change. The number will determine what the user can change.
                if ("1234".contains(input)){

                    if (input.equals("1")){
                        System.out.println("Please enter new username:");
                        name = String.valueOf((reader.readLine()));

                        log = false;

                    } else if (input.equals("2")){
                        System.out.println("Please enter new password.");
                        passhash = String.valueOf(Math.abs((reader.readLine()).hashCode()));

                        log = false;

                    }else if (input.equals("3")){
                        Random rnd = new Random();
                        int newFlair = rnd.nextInt(999999);

                        log = false;
                    }else if (input.equals("4")){
                        log = false;
                        change = false;
                    }

                }else{
                    System.out.println("Invalid selection.");
                }
            }
        }

        if (change){
            //String key = u.getKey(user);
            User newUser = new User(name, passhash, uglyLink, flair);
            //u.remove(key); //Since no method for extracting a key has been made, this does nothing.
            u.putUser(String.valueOf(newUser.makeString().hashCode()), newUser);
        }





    }
}
