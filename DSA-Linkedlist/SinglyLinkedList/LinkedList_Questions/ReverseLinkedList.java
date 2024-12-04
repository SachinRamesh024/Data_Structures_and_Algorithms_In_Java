class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class ReverseLinkedList {

    Node head;

    // Insert a node at the end of the list
    public void insertAtPosition(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Reverse the linked list
    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node after = null;

        while (current != null) {
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        return prev;
    }

    // Print the linked list
    public void print() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the reverse functionality
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();

        // Insert elements into the list
        list.insertAtPosition(1);
        list.insertAtPosition(2);
        list.insertAtPosition(3);
        list.insertAtPosition(4);
        list.insertAtPosition(5);

        // Print the original list
        System.out.print("Original list: ");
        list.print();

        // Reverse the linked list
        Node reversedHead = list.reverse(list.head);

        // Print the reversed list
        System.out.print("Reversed list: ");
        while (reversedHead != null) {
            System.out.print(reversedHead.data + " -> ");
            reversedHead = reversedHead.next;
        }
        System.out.println("null");
    }
}

