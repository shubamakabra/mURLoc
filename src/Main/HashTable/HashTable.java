package Main.HashTable;

import java.sql.SQLOutput;

public class HashTable {
    private int defaultSize = 10000007;
    private int defaultR = 31;

    private int maxSize;
    private int size;
    private int R;
    private Table table;

    public HashTable(int s, int r){
        this.table = makeTable(s, r);
        this.maxSize = table.getSize();
        this.R = table.getR();
    }

    public HashTable(int s){
        this.table = makeTable(s);
        this.maxSize = table.getSize();
        this.R = table.getR();
    }

    public HashTable(){
        this.maxSize = this.defaultSize;
        this.R = this.defaultR;
        this.table = makeTable();
    }

    public int hash(String string){
        int hash = 0;
        for (int i = 0; i < string.length(); i++){
            hash = (R * hash + string.charAt(i)) % size;
        }
        return hash;
    }

    public void put(String key, String val){
        if (size >= maxSize/2){this.resize(); } //If the number of entries reaches 50% of the list size, increase list size.

        table.put(key,val);
        this.size = table.getSize();
    }

    public String get(String key) {
        System.out.println("");
        String k = table.get(key);

        if (key != null){
            return k;
        } else {
            System.err.println("Key did not identify any entry. Redirecting to home page.");
            return "https://google.com"; //this could clearly redirected elsewhere, but google is used as example.
        }
    }

    private Table makeTable(int s, int R){
        Table t = new Table(s, R);
        return t;
    }

    private Table makeTable(int s){
        Table t = new Table(s);
        return t;
    }

    private Table makeTable(){
        Table t = new Table();
        return t;
    }

    private void resize(){
        this.maxSize = table.resize();
    }

    public int getSize(){
        return table.maxSize;
    }

    public int getR(){
        return table.R;
    }


}
