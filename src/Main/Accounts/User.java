package Main.Accounts;

//This class is a singular user, containing his/her name, password hash and the ugly URL.
public class User {
    String name;
    String passHash;
    String uURL;

    public User(String Name, String passhash, String ugly){
        //System.out.println("Creating user for " + Name + "!");

        this.name = Name;
        this.passHash = passhash;
        this.uURL = ugly;
    }

    // {Name, password hash, nice URL, ugly URL}
    public String makeString(){
        return "{" + this.name + "," + this.passHash + "," + this.uURL + "} \n" ;
    }

    //A function to make the user entry into a postable String.
    public void printUser(){
        System.out.println(this.makeString());
    }

    public String getName(){
        return this.name;
    }

    public String getPassHash(){
        return this.passHash;
    }

    public String getuURL(){
        return this.uURL;
    }
}
