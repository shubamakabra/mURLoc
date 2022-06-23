package Main.HashTable;

public class HashTable {
    private int maxSize;
    private int size;
    private int R;
    private Table table;

    public HashTable(int s, int r){
        this.size = s;
        this.R = r;
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
        if (size >= maxSize/2){this.resize(); }
        table.put(key,val);
        this.size = table.getSize();
    }

    private Table makeTable(){
        Table t = new Table(this.size, this.R);
        return t;
    }

    private void resize(){
        this.maxSize = table.resize();
    }


}
