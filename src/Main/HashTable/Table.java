package Main.HashTable;

import static java.util.Objects.hash;

public class Table {
        int[] primes = {1, 1009, 10007, 100003, 10000003, 100000007, 1000000019};

        int defaultMaxSize = 100000007;
        int defaultR = 31;

        int maxSize;
        int R;
        int size;

        private String[] keys;
        private String[] vals;

        public Table(int s, int r){
            this.maxSize = getNextSize(s);
            this.R = r;

            keys = new String[maxSize];
            vals = new String[maxSize];
        }

        //Overloaded initializer, which only takes the table size as input.
        public Table(int s){
            this.maxSize = getNextSize(s);
            this.R = defaultR;

            keys = new String[maxSize];
            vals = new String[maxSize];
        }

        //Third overloaded initializer, taking no input but creates a default table.
        public Table(){
            this.maxSize = defaultMaxSize;
            this.R = defaultR;

            keys = new String[maxSize];
            vals = new String[maxSize];
        }

        //Method for inserting an entry into the table.
        public void put(String key, String val){
            //For the whole list, starting at the hashed index, check if there is an entry with the same key.
            int i;
            for (i = hash(key); keys[i] != null; i = (i + 1) % maxSize) {
                //if the key is found, then insert new values.
                if (keys[i].equals(key)) {
                    vals[i] = val;
                    return;
                }
            }
            //if the key is not found, insert entry at index = hash(key).
            keys[i] = key;
            vals[i] = val;
            size++;
        }

        public String get(String key){
            for (int i = hash(key); keys[i] != null; i = (i + 1) % maxSize){
                if (keys[i].equals(key)){
                    return vals[i];
                }
            }
            return null;
        }

        //Checks the list of primes for the lowest size that can include s elements and returns it.
        private int getNextSize(int s){
            for (int i = 0; primes[i] < s; i++) {
                if (s > primes[i]){
                    s = primes[i+1];
                }
            }
            return s;
        }

        //Resizes the HashTable by making a new one that is larger, then rehashing and inserting all old entries.
        public void resize(int newSize){
            Table t = new Table(newSize);
            for (int i = 0; i < maxSize; i++){
                if (keys[i] != null){
                    t.put(keys[i], vals[i]);
                }
            }
            this.keys = t.keys;
            this.vals = t.vals;
            this.maxSize = t.maxSize;
        }

        public int resize(){
            int newSize = this.getNextSize(this.maxSize);
            this.resize(newSize);
            return newSize;
        }

        public int getSize(){
            return size;
        }

        public int getR(){
            return this.R;
        }
}
