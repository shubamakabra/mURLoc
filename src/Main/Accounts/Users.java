package Main.Accounts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Users {
    private int size = 10000;
    private HashMap<String, User> users;

    public Users(){
        users = new HashMap<String, User>();
        //this.users = getUsers();
    }

    public void addUser(User u){
        String hash = String.valueOf(u.hashCode());
        System.out.println(hash);
        users.put(hash, u);
    }

    public void writeUsers() {
        try {
            System.out.println("Saving users to file!");

            FileWriter myWriter = new FileWriter("users.txt");
            myWriter.write("[Key, {User name, Password hash, ugly URL, nice URL}]\n\n");

            User user;
            int n = 0;
            for (String i : users.keySet()) {
                user = users.get(i);
                if (user != null) {
                    n++;
                    myWriter.write(user.makeString());
                }
            }

            myWriter.close();
            System.out.println("Successfully wrote " + n + " users to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred when writing to file.");
            e.printStackTrace();
        }

        getUsers();
    }

    //read users from file. TODO
    private void getUsers(){
        System.out.println("Reading users from file.");
        //read from file.
        this.users = new HashMap<String, User>();

            try {
                File myObj = new File("users.txt");
                Scanner myReader = new Scanner(myObj);

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    makeUserfromString(data);
                }

                myReader.close();
                System.out.println("Successfully read all users.");

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }

    private void makeUserfromString(String s){
        List<String> items = Arrays.asList(s.split("\\s*,\\s*"));
        //remove all special symbols (namely "()" and "{}" ).
        for (String k : items){
            k.replaceAll("[{}()]","");
        }

        User user = new User(items.get(1), items.get(2), items.get(4));
        user.printUser();


    }
}
