package Main.Accounts;

import Main.Main;
import Main.Networking.URLholder;

public class User {
    String key;

    String name;
    String passHash;
    URLholder URLs;

    public User(String Name, String passhash, String ugly){
        System.out.println("Creating user for " + Name + "!");

        String nice = String.valueOf(ugly.hashCode());

        this.key = nice;
        this.name = Name;
        this.passHash = passhash;
        this.URLs = new URLholder(ugly, nice);
    }

    // [Key, {Name, password hash, nice URL, ugly URL}]
    public String makeString(){
        return "(" + this.key + ", {" + this.name + ", " + this.passHash + ", " + this.URLs.getNice() + ", " + this.URLs.getUgly() + "} ) \n" ;
    }

    public void printUser(){
        System.out.println(this.makeString());
    }
    public String getName(){
        return this.name;
    }

    public String getPassHash(){
        return this.passHash;
    }

    public URLholder getURLs(){
        return this.URLs;
    }
}
