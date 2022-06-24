package Main.Accounts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Registration {

    public Registration(){
    }

    //A function that just sets up a looped promt, creating a user based on user input .
    //NOTE: There are no limitations/checks on what is entered, and this should clearly be included.
    public static void registrating(Users u) throws IOException {
        boolean reg = true;

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while (reg) {

            System.out.println("Please input username: ");
            String name = reader.readLine();

            System.out.println("Please input password: ");
            String passhash = String.valueOf(Math.abs((reader.readLine()).hashCode()));

            System.out.println("Please input ugly link. (The nice link will be computed automatically.)");
            String ugly = String.valueOf(reader.readLine());

            User user = new User(name.strip(), passhash.strip(), ugly.strip());
            String key = String.valueOf(Math.abs(user.makeString().hashCode()));

            System.out.println("Your webpage can be reached at: http://localhost:8080/" + key);
            System.out.println("So please remember to save your personal mURL! ");

            u.putUser(key, user);

            System.out.println("User profile made:");
            user.printUser();

            System.out.println("Add another user? Y/N");
            String YN = String.valueOf(reader.readLine());

            System.out.println(YN);

            if (YN.equals("N") || YN.equals("n")){
                u.writeUsers();
                break;
            }
        }
        reader.close();
    }
}
