//package DLinkedList;

//Java program for the above approach

class Node {
    int data;
    Node prev;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

public class DoubleLL {

    // Node class for doubly linked list

    // Head of the list
    private Node head;

    // Constructor
    DoubleLL() {
        head = null;
    }

    // Method to add a node at the front of the list
    public void addFront(int data) {
        Node newNode = new Node(data);

        // If the list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head; // Link new node to the current head
        head.prev = newNode; // Link the current head back to the new node
        head = newNode; // Move head to point to the new node
    }

    // Method to add a node at the end of the list
    public void addEnd(int data) {
        Node newNode = new Node(data);

        // If the list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        // Traverse to the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode; // Link the last node to the new node
        newNode.prev = temp; // Link the new node back to the last node
    }

    // Method to delete a node from the list
    public void deleteNode(int data) {
        if (head == null) {
            return;
        }

        Node temp = head;

        // If the head node is to be deleted
        if (temp.data == data) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        // Traverse the list to find the node to delete
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        // If the node was not found
        if (temp == null) {
            return;
        }

        // Remove the node
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    // Method to display the list from front to back
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to display the list from back to front
    public void displayBackward() {
        if (head == null) {
            return;
        }

        Node temp = head;
        // Traverse to the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Now traverse backward using the prev pointers
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    void deleteFromPos(int pos){

        if(head==null){
            System.out.println("list is empty");
            return;
        }
        if(pos==1){
            head.next.prev=null;
            head=head.next;
            return;
        }

        Node temp = head;
        for(int i=1;i<pos-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        temp.prev=temp;

}


    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();

        // Adding elements to the list
        dll.addFront(10);
        dll.addFront(20);
        dll.addEnd(30);
        dll.addEnd(40);

        // Display the list forward and backward
        System.out.println("List from front to back:");
        dll.displayForward();

        System.out.println("List from back to front:");
        dll.displayBackward();

        // Delete an element and display again
        dll.deleteNode(30);

        System.out.println("After deletion:");
        dll.displayForward();
        dll.deleteFromPos(3);
        dll.displayForward();
    }
}
