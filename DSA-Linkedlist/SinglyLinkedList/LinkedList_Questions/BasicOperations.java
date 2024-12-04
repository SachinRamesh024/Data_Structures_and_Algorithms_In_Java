class BasicOperations {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public BasicOperations() {
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

    public int sum() {
        Node current = head;
        int sum = 0;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printOddElements() {
        Node current = head;
        System.out.println("Odd elements: ");
        while (current != null) {
            if (current.data % 2 != 0) {
                System.out.print(current.data + " -> ");
            }
            current = current.next;
        }
        System.out.println("null");
    }

    public void printEvenElements() {
        Node current = head;
        System.out.println("Even elements: ");
        while (current != null) {
            if (current.data % 2 == 0) {
                System.out.print(current.data + " -> ");
            }
            current = current.next;
        }
        System.out.println("null");
    }

    public void printLastElement() {
        Node current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        System.out.println("Last element is: " + current.data);
    }

    public static void main(String[] args) {
        BasicOperations list = new BasicOperations();

        list.insertAtPosition(1, 1);
        list.insertAtPosition(3, 2);
        list.insertAtPosition(5, 3);
        list.insertAtPosition(8, 4);
        list.insertAtPosition(9, 5);

        list.printOddElements();
        list.printEvenElements();
        list.printLastElement();

        System.out.println("Sum of all elements: " + list.sum());
        System.out.println("Search 5 in list: " + list.search(5));
    }
}

