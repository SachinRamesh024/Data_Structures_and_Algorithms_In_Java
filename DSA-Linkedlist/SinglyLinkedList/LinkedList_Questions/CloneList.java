class CloneList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public CloneList() {
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

    public Node clone(Node h1) {
        if (h1 == null) {
            return null;
        }
        Node current1 = h1;
        Node h2 = new Node(current1.data);
        Node current2 = h2;
        while (current1.next != null) {
            current1 = current1.next;
            current2.next = new Node(current1.data);
            current2 = current2.next;
        }
        return h2;
    }

    public static void main(String[] args) {
        CloneList list = new CloneList();
        list.insertAtPosition(1, 1);
        list.insertAtPosition(3, 2);
        list.insertAtPosition(5, 3);

        Node clonedList = list.clone(list.head);

        System.out.println("Cloned List: ");
        while (clonedList != null) {
            System.out.print(clonedList.data + " -> ");
            clonedList = clonedList.next;
        }
        System.out.println("null");
    }
}

