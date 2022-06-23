package Main.Networking;

public class URLholder {
    String ugly;
    String nice;

    public URLholder(String u, String n){
        this.ugly = u;
        this.nice = n;
    }

    public String getUgly(){
        return this.ugly;
    }

    public String getNice(){
        return this.nice;
    }
}
