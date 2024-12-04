class RemoveDuplicates {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public RemoveDuplicates() {
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
                System.out.println("Index out of bound");
                return;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
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
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicates list = new RemoveDuplicates();
        list.insertAtPosition(1, 1);
        list.insertAtPosition(1, 2);
        list.insertAtPosition(2, 3);
        list.insertAtPosition(3, 4);
        list.insertAtPosition(3, 5);

        list.head = list.deleteDuplicates(list.head);

        System.out.println("List after removing duplicates: ");
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

