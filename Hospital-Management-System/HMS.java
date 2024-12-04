import java.util.*;

class Patient {
    String name;
    int age;
    String id;
    String history;

    public Patient(String id, String name, int age, String history) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.history = history;
    }


    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", History: " + history;
    }
}

// Node class for custom Hashtable
class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

// Custom Hashtable implementation
class CustomHashtable<K, V> {
    private ArrayList<HashNode<K, V>> bucketArray;
    private int capacity; // Number of buckets
    private int size;

    public CustomHashtable() {
        bucketArray = new ArrayList<>();
        capacity = 10;
        size = 0;

        for (int i = 0; i < capacity; i++) {
            bucketArray.add(null);
        }
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(index);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucketArray.set(index, newNode);

        if ((1.0 * size) / capacity >= 0.7) {
            resize();
        }
    }
    public V get(K key) {
        int index = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private void resize() {
        ArrayList<HashNode<K, V>> temp = bucketArray;
        bucketArray = new ArrayList<>();
        capacity *= 2;
        size = 0;

        for (int i = 0; i < capacity; i++) {
            bucketArray.add(null);
        }

        for (HashNode<K, V> headNode : temp) {
            while (headNode != null) {
                put(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }
}

// BST Node for age-based priority
class BSTNode {
    Patient patient;
    BSTNode left, right;

    public BSTNode(Patient patient) {
        this.patient = patient;
    }
}

// Priority Queue for appointments
class AppointmentQueue {
    private PriorityQueue<Patient> queue;

    public AppointmentQueue() {
        queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.age)); // Higher age = higher priority
    }

    public void addAppointment(Patient patient) {
        queue.add(patient);
        System.out.println("Appointment scheduled for: " + patient.name);
    }

    public void displayAppointments() {
        System.out.println("Appointments (in priority order):");
        for (Patient p : queue) {
            System.out.println(p.name + " (Age: " + p.age + ")");
        }
    }

    public void removeNextAppointment() {
        if (!queue.isEmpty()) {
            Patient next = queue.poll();
            System.out.println("Next appointment is for: " + next.name);
        } else {
            System.out.println("No appointments available.");
        }
    }
}

// Binary Search Tree for age-based priority management
class AgePriorityBST {
    private BSTNode root;

    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private BSTNode insertRecursive(BSTNode node, Patient patient) {
        if (node == null) {
            return new BSTNode(patient);
        }
        if (patient.age < node.patient.age) {
            node.left = insertRecursive(node.left, patient);
        } else {
            node.right = insertRecursive(node.right, patient);
        }
        return node;
    }

    public void displayInOrder() {
        System.out.println("Patients sorted by age:");
        inOrderTraversal(root);
    }

    private void inOrderTraversal(BSTNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.patient);
            inOrderTraversal(node.right);
        }
    }
}

public class HMS {
    private CustomHashtable<String, Patient> patientRecords; // Custom Hashtable for patient history lookup
    private AppointmentQueue appointmentQueue;
    private AgePriorityBST agePriorityBST;

    public HMS() {
        patientRecords = new CustomHashtable<>();
        appointmentQueue = new AppointmentQueue();
        agePriorityBST = new AgePriorityBST();
    }

    // Add a new patient
    public void addPatient(String id, String name, int age, String history) {
        Patient newPatient = new Patient(id, name, age, history);
        patientRecords.put(id, newPatient);
        appointmentQueue.addAppointment(newPatient);
        agePriorityBST.insert(newPatient);
        System.out.println("Patient added: " + newPatient);
    }

    // Find patient history by ID
    public void findPatientHistory(String id) {
        if (patientRecords.containsKey(id)) {
            System.out.println("Patient history: " + patientRecords.get(id).history);
        } else {
            System.out.println("No record found for ID: " + id);
        }
    }

    public void displayAppointments() {
        appointmentQueue.displayAppointments();
    }

    public void displayPatientsByAge() {
        agePriorityBST.displayInOrder();
    }

    public static void main(String[] args) {
        HMS hms = new HMS();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n =====Hospital Management System=====");
            System.out.println("| 1. Add Patient                     |");
            System.out.println("| 2. Find Patient History            |");
            System.out.println("| 3. Display Appointments            |");
            System.out.println("| 4. Display Patients Sorted by Age  |");
            System.out.println("| 5. Exit                            |");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Medical History: ");
                    String history = scanner.nextLine();
                    hms.addPatient(id, name, age, history);
                    break;
                case 2:
                    System.out.print("Enter Patient ID: ");
                    String searchId = scanner.nextLine();
                    hms.findPatientHistory(searchId);
                    break;
                case 3:
                    hms.displayAppointments();
                    break;
                case 4:
                    hms.displayPatientsByAge();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}


