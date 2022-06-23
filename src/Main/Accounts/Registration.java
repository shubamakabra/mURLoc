package Main.Accounts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Registration {

    public Registration(){
    }


    public static void registrating(Users u) throws IOException {
        boolean reg = true;

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while (reg) {

            System.out.println("Please input username: ");
            String name = reader.readLine();

            System.out.println("Please input password: ");
            String passhash = String.valueOf((reader.readLine()).hashCode());

            System.out.println("Please input ugly link. (The nice link will be computed automatically.)");
            String ugly = String.valueOf(reader.readLine());

            System.out.println(name + passhash + ugly);

            User user = new User(name, passhash, ugly);
            u.addUser(user);

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
