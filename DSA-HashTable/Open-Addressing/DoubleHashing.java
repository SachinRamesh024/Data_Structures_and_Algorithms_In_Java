class DoubleHashing {
    private int tableSize = 10;
    private Object[] table; // Object array for the table
    private int[] status; // Array to track whether a slot is occupied

    public DoubleHashing() {
        table = new Object[tableSize];
        status = new int[tableSize]; // 0 - empty, 1 - occupied, -1 - deleted
    }

    // Primary Hash Method for Object key
    private int primaryHash(Object key) {
        return Math.abs(key.hashCode()) % tableSize;
    }

    // Secondary Hash Method for Object key (must not return 0)
    private int secondaryHash(Object key) {
        int prime = 7; // A small prime number
        return prime - (Math.abs(key.hashCode()) % prime);
    }

    // Choose hash function (Primary + Secondary)
    private int hashFunction(Object key, int i) {
        int primary = primaryHash(key);
        int secondary = secondaryHash(key);
        return (primary + i * secondary) % tableSize;
    }

    // Insert method for Object key with double hashing
    public void add(Object key) {
        if (loadFactor() > 0.7) {
            rehash(); // Rehash if load factor exceeds 0.7
        }

        int hash = primaryHash(key);
        int initialHash = hash;
        int i = 0;  // Start probing from 0

        while (status[hash] == 1) { // Slot is occupied, move to next
            if (table[hash].equals(key)) {
                return; // Duplicate key, no need to insert
            }
            i++;  // Increment probe count
            hash = hashFunction(key, i); // Double hashing
            if (hash == initialHash) {
                return; // Avoid infinite loop if the table is full
            }
        }

        table[hash] = key;
        status[hash] = 1; // Mark the slot as occupied
    }

    // Get method for Object key using double hashing
    public Object get(Object key) {
        int hash = primaryHash(key);
        int initialHash = hash;
        int i = 0;  // Start probing from 0

        while (status[hash] != 0) { // Until we find an empty slot
            if (status[hash] == 1 && table[hash].equals(key)) {
                return table[hash]; // Key found
            }
            i++;  // Increment probe count
            hash = hashFunction(key, i); // Double hashing
            if (hash == initialHash) {
                break; // We have cycled through the table
            }
        }

        return null; // Key not found
    }

    // Remove method for Object key using double hashing
    public void remove(Object key) {
        int hash = primaryHash(key);
        int initialHash = hash;
        int i = 0;  // Start probing from 0

        while (status[hash] != 0) { // Until we find an empty slot
            if (status[hash] == 1 && table[hash].equals(key)) {
                table[hash] = null;
                status[hash] = -1; // Mark slot as deleted
                return;
            }
            i++;  // Increment probe count
            hash = hashFunction(key, i); // Double hashing
            if (hash == initialHash) {
                break; // We have cycled through the table
            }
        }
    }

    // Calculate load factor
    private double loadFactor() {
        return (double) size() / tableSize;
    }

    // Get current size (number of elements)
    private int size() {
        int size = 0;
        for (int i = 0; i < tableSize; i++) {
            if (status[i] == 1) {
                size++;
            }
        }
        return size;
    }

    // Rehashing method
    private void rehash() {
        System.out.println("Rehashing triggered...");

        // Save old table and status
        Object[] oldTable = table;
        int[] oldStatus = status;

        // Double the table size
        tableSize *= 2;
        table = new Object[tableSize];
        status = new int[tableSize];

        // Reinsert all keys into the new table
        for (int i = 0; i < oldTable.length; i++) {
            if (oldStatus[i] == 1) {
                add(oldTable[i]); // Reinsert using the new table
            }
        }
    }

    // Display the table
    public void displayTable() {
        for (int i = 0; i < tableSize; i++) {
            System.out.println("Bucket " + i + ": " + (status[i] == 1 ? table[i] : "empty"));
        }
    }

    public static void main(String[] args) {
        // Creating a hash table with object keys using double hashing
        DoubleHashing ht = new DoubleHashing();

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

