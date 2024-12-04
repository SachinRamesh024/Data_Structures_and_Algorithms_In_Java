class QuadraticProbing {
    private int tableSize = 10;
    private Object[] table; // Object array for the table
    private int[] status; // Array to track whether a slot is occupied

    public QuadraticProbing() {
        table = new Object[tableSize];
        status = new int[tableSize]; // 0 - empty, 1 - occupied, -1 - deleted
    }

    // Division Hash Method for Object key
    private int divisionHash(Object key) {
        return Math.abs(key.hashCode()) % tableSize;
    }

    // Multiplication Hash Method for Object key
    private int multiplicationHash(Object key) {
        double A = 0.618033; // Constant between 0 and 1
        int hashCode = Math.abs(key.hashCode());
        double fractionalPart = (hashCode * A) % 1;
        return (int) (tableSize * fractionalPart);
    }

    // Choose hash function (you can swap between division and multiplication)
    private int hashFunction(Object key) {
        return divisionHash(key); // Or you can use multiplicationHash(key);
    }

    // Insert method for Object key with quadratic probing
    public void add(Object key) {
        if (loadFactor() > 0.7) {
            rehash(); // Rehash if load factor exceeds 0.7
        }

        int hash = hashFunction(key);
        int initialHash = hash;
        int i = 1;  // Start quadratic probing with i = 1

        while (status[hash] == 1) { // Slot is occupied, move to next
            if (table[hash].equals(key)) {
                return; // Duplicate key, no need to insert
            }
            hash = (hash + i * i) % tableSize; // Quadratic probing


            i++; // Increment i for the next probe
            if (hash == initialHash) {
                return; // Avoid infinite loop if the table is full
            }
        }

        table[hash] = key;
        status[hash] = 1; // Mark the slot as occupied
    }

    // Get method for Object key using quadratic probing
    public Object get(Object key) {
        int hash = hashFunction(key);
        int initialHash = hash;
        int i = 1;  // Start quadratic probing with i = 1

        while (status[hash] != 0) { // Until we find an empty slot
            if (status[hash] == 1 && table[hash].equals(key)) {
                return table[hash]; // Key found
            }
            hash = (hash + i * i) % tableSize; // Quadratic probing
            i++; // Increment i for the next probe
            if (hash == initialHash) {
                break; // We have cycled through the table
            }
        }

        return null; // Key not found
    }

    // Remove method for Object key using quadratic probing
    public void remove(Object key) {
        int hash = hashFunction(key);
        int initialHash = hash;
        int i = 1;  // Start quadratic probing with i = 1

        while (status[hash] != 0) { // Until we find an empty slot
            if (status[hash] == 1 && table[hash].equals(key)) {
                table[hash] = null;
                status[hash] = -1; // Mark slot as deleted
                return;
            }
            hash = (hash + i * i) % tableSize; // Quadratic probing
            i++; // Increment i for the next probe
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
        // Creating a hash table with object keys using quadratic probing
        QuadraticProbing ht = new QuadraticProbing();

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

