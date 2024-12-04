class DeleteMiddleElement {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public DeleteMiddleElement() {
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

    public void deleteMiddleNode() {
        if (head == null || head.next == null) {
            System.out.println("List is too short");
            return;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;
    }

    public static void main(String[] args) {
        DeleteMiddleElement list = new DeleteMiddleElement();
        list.insertAtPosition(1, 1);
        list.insertAtPosition(3, 2);
        list.insertAtPosition(5, 3);
        list.insertAtPosition(7, 4);
        list.insertAtPosition(9, 5);

        list.deleteMiddleNode();

        System.out.println("List after deleting middle element: ");
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

