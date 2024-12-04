class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                return;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void deleteFromPosition(int position) {
        if (head == null) {
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next == null) {
            return;
        }
        current.next = current.next.next;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node reverse(Node head) {
        Node current = head;
        Node prev = null;
        Node after = null;
        while (current != null) {
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        return prev;
    }

    public Node deleteDuplicates(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (prev.data == current.data) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }


        public static void main(String[] args) {
            LinkedList list = new LinkedList();
            list.insertAtPosition(1, 1);
            list.insertAtPosition(3, 2);
            list.insertAtPosition(5, 3);
            list.insertAtPosition(8, 4);
            list.insertAtPosition(9, 5);
            list.print();

            //reverse
            Node reversedHead = list.reverse(list.head);
            System.out.println("Reversed List:");
            while (reversedHead != null) {
                System.out.print(reversedHead.data + " -> ");
                reversedHead = reversedHead.next;
            }
            System.out.println("null");

            //delete duplicates
            Node noDuplicates = list.deleteDuplicates(list.head);
            System.out.println("List after removing duplicates:");
            while (noDuplicates != null) {
                System.out.print(noDuplicates.data + " -> ");
                noDuplicates = noDuplicates.next;
            }
            System.out.println("null");

        }

}


