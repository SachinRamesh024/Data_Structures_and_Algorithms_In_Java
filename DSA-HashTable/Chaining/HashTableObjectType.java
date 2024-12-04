import java.util.LinkedList;

class HashTableObjectType {
    private int tableSize = 10;
    private LinkedList<Object>[] table;

    public HashTableObjectType() {
        table = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int divisionHash(Object key) {
        return Math.abs(key.hashCode()) % tableSize;
    }

    private int multiplicationHash(Object key) {
        double A = 0.618033; // Constant between 0 and 1
        int hashCode = Math.abs(key.hashCode());
        double fractionalPart = (hashCode * A) % 1;
        return (int) (tableSize * fractionalPart);
    }

    private int hashFunction(Object key) {
        // return divisionHash(key);
        return multiplicationHash(key);
    }

    public void add(Object key) {
        if (loadFactor() > 0.7) {
            rehash(); // Rehash if load factor exceeds 0.7
        }

        int hash = hashFunction(key);
        if (!table[hash].contains(key)) { // Avoid duplicate keys
            table[hash].add(key);
        }
    }

    public Object get(Object key) {
        int hash = hashFunction(key);
        for (Object k : table[hash]) {
            if (k.equals(key)) {
                return k;
            }
        }
        return null; // Key not found
    }

    public void remove(Object key) {
        int hash = hashFunction(key);
        table[hash].remove(key);
    }

    private double loadFactor() {
        return (double) size() / tableSize;
    }

    private int size() {
        int size = 0;
        for (int i = 0; i < tableSize; i++) {
            size += table[i].size();
        }
        return size;
    }

    // Rehashing method
    private void rehash() {
        System.out.println("Rehashing triggered...");

        // Save old table
        LinkedList<Object>[] oldTable = table;

        // Double the table size
        tableSize *= 2;
        table = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }

        // Reinsert all keys into the new table
        for (LinkedList<Object> bucket : oldTable) {
            for (Object key : bucket) {
                add(key); // Reinsert using the new table
            }
        }
    }

    public void displayTable() {
        for (int i = 0; i < tableSize; i++) {
            System.out.println("Bucket " + i + ": " + table[i]);
        }
    }

    public static void main(String[] args) {
        // Creating a hash table with object keys
        HashTableObjectType ht = new HashTableObjectType();

        // Inserting different objects
        ht.add("apple");  // String object
        ht.add(123);       // Integer object
        ht.add(45.67);     // Double object

        ht.displayTable();

        System.out.println("Search 'apple': " + ht.get("apple"));
        System.out.println("Search 123: " + ht.get(123));
        System.out.println("Search 45.67: " + ht.get(45.67));

        ht.remove("apple");
        System.out.println("Search 'apple' after removal: " + ht.get("apple"));

        // Test rehashing
        ht.add("watermelon");
        ht.add("peach");
        ht.add("strawberry");
        ht.add(99);        // Adding integer after rehashing

        ht.displayTable();
    }
}


