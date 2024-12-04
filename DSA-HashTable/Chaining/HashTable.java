import java.util.LinkedList;

class HashTable {
    private int tableSize = 10;
    private LinkedList<String>[] table;

    public HashTable() {
        table = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int divisionHash(String key) {
        return Math.abs(key.hashCode()) % tableSize;
    }

    private int multiplicationHash(String key) {
        double A = 0.618033; // Constant between 0 and 1
        int hashCode = Math.abs(key.hashCode());
        double fractionalPart = (hashCode * A) % 1;
        return (int) (tableSize * fractionalPart);
    }

    private int hashFunction(String key) {
        // return divisionHash(key);
        return multiplicationHash(key);
    }

    public void add(String key) {
        if (loadFactor() > 0.7) {
            rehash(); // Rehash if load factor exceeds 0.7
        }

        int hash = hashFunction(key);
        if (!table[hash].contains(key)) { // Avoid duplicate keys
            table[hash].add(key);
        }
    }

    public String get(String key) {
        int hash = hashFunction(key);
        for (String k : table[hash]) {
            if (k.equals(key)) {
                return k;
            }
        }
        return null; // Key not found
    }

    public void remove(String key) {
        int hash = hashFunction(key);
        table[hash].remove(key);
    }

    public boolean search(String key) {
        int hash = hashFunction(key);
        return table[hash].contains(key);
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

    private void rehash() {
        System.out.println("Rehashing triggered...");

        // Save old table
        LinkedList<String>[] oldTable = table;

        // Double the table size
        tableSize *= 2;
        table = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }

        // Reinsert all keys into the new table
        for (LinkedList<String> bucket : oldTable) {
            for (String key : bucket) {
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
        HashTable ht = new HashTable();
        ht.add("apple");
        ht.add("banana");
        ht.add("orange");
        ht.add("grape");

        ht.displayTable();

        System.out.println("Search 'orange': " + ht.search("orange"));
        System.out.println("Get 'banana': " + ht.get("banana"));
        ht.remove("orange");
        System.out.println("Search 'orange' after deletion: " + ht.search("orange"));

        // Test rehashing
        ht.add("watermelon");
        ht.add("peach");
        ht.add("strawberry");
        ht.add("blueberry");
        ht.add("kiwi");
        ht.add("mango");
        ht.add("pineapple");
        ht.displayTable();
    }
}

