package Main.HashTable;

public class Hasher {
    private int size;
    private int R;
    private Table table;

    public Hasher(int s, int r){
        this.size = s;
        this.R = r;
        this.table = getTable(size);
    }

    public int hash(String string){
        int hash = 0;
        for (int i = 0; i < string.length(); i++){
            hash = (R * hash + string.charAt(i)) % size;
        }
        return hash;
    }

    private Table geTable(int s){
        Table t = new Table();
        return t
    }
}
