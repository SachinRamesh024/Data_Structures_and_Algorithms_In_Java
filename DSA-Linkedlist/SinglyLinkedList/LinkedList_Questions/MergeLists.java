class MergeLists {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public MergeLists() {
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

    public Node merge(Node h1, Node h2) {
        Node t1 = h1;
        Node t2 = h2;
        Node h = new Node(100); // dummy data
        Node t = h;
        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                t.next = t1;
                t = t1;
                t1 = t1.next;
            } else {
                t.next = t2;
                t = t2;
                t2 = t2.next;
            }
        }
        if (t1 == null) {
            t.next = t2;
        } else { // t2 is null
            t.next = t1;
        }
        return h.next;
    }

    public static void main(String[] args) {
        MergeLists list1 = new MergeLists();
        MergeLists list2 = new MergeLists();

        list1.insertAtPosition(1, 1);
        list1.insertAtPosition(3, 2);
        list1.insertAtPosition(5, 3);

        list2.insertAtPosition(2, 1);
        list2.insertAtPosition(4, 2);
        list2.insertAtPosition(6, 3);

        Node mergedList = list1.merge(list1.head, list2.head);

        System.out.println("Merged List: ");
        while (mergedList != null) {
            System.out.print(mergedList.data + " -> ");
            mergedList = mergedList.next;
        }
        System.out.println("null");
    }
}

