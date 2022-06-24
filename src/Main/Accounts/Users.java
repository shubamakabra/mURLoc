package Main.Accounts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Users {
    private HashMap<String, User> users;
    private int n;

    public Users(){
        users = new HashMap<String, User>();
        n = 0;
        this.makeUserList();
    }

    public void putUser(String key, User u){
        users.put(key, u);
        n++;
    }

    public User getUser(String key){
        return users.get(key);
    }

    public boolean contains(String key){
        return users.containsKey(key);
    }

    public String getUglyURL(String key){
        return this.getUser(key).getuURL();
    }

    public Set<String> getKeys(){
        return users.keySet();
    }

    public void writeUsers() {
        if (n > 0) {
            try {
                System.out.println("Saving users to file!");

                FileWriter myWriter = new FileWriter("users.txt");
                //myWriter.write("[Key, {User name, Password hash, ugly URL, nice URL}]\n\n");

                User user;
                int m = 0;
                for (String i : users.keySet()) {
                    user = users.get(i);
                    if (user != null) {
                        m++;
                        myWriter.write(user.makeString());
                    }
                }

                myWriter.close();

                if (m > 0) {

                    System.out.println("Successfully wrote " + m + " users to the file.");
                } else {
                    System.out.println("No users written to file.");
                }

            } catch (IOException e) {
                System.out.println("An error occurred when writing to file.");
                e.printStackTrace();
            }
        } else{
            System.out.println("No users to write to file!");
        }
    }

    //read users from file and makes a user list. This is to ensure that previously saved users are kept.
    public void makeUserList(){
        System.out.println("Reading users from file.");

        //read from file.
        this.users = new HashMap<String, User>();
        User u;

            try {
                File myObj = new File("users.txt");
                Scanner myReader = new Scanner(myObj);

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    u = makeUserfromString(data);
                    String key = String.valueOf(Math.abs(u.makeString().hashCode()));
                    this.users.put(key, u);
                    n++;

                }
                if (n == 0) {
                    System.out.println("No users found!");
                } else {
                    System.out.println("Successfully read all users.");
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            getKeys();
    }

    private User makeUserfromString(String s){
        String[] items = s.split("\\s*,\\s*");

        //remove all special symbols (namely "()" and "{}" ).
        String[] res;
        int l = 0;
        for (int i = 0; i < items.length; i++){
            items[i] = items[i].replaceAll("[}{]","");
        }

        User user = new User(items[0].strip(), items[1].strip(), items[2].strip());
        user.printUser();
        return user;
    }

    public void printUsers(){
        if (n < 0) {
            System.out.println("Printing users!");
            User user;
            int n = 0;

            for (String i : users.keySet()) {
                user = users.get(i);
                if (user != null) {
                    n++;
                    System.out.println(user.makeString());
                }
            }
        }else {
        }
    }

    public boolean empty(){
        return (n == 0);
    }
}
