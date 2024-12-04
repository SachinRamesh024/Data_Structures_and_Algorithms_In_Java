class ELinkedQueue {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head, tail;
    private int size;

    public ELinkedQueue() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = head.data;
        head = head.next;
        size--;
        return element;
    }

    public int size() {
        return size;
    }
}

public class EqualsLinkedQueue {
    public static boolean equals(ELinkedQueue q1, ELinkedQueue q2) {
        ELinkedQueue temp1 = new ELinkedQueue();
        ELinkedQueue temp2 = new ELinkedQueue();

        boolean isEqual = true;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int v1 = q1.dequeue();
            int v2 = q2.dequeue();

            if (v1 != v2) {
                isEqual = false;
            }

            temp1.enqueue(v1);
            temp2.enqueue(v2);
        }

        // Restore elements back into q1 and q2
        while (!temp1.isEmpty()) {
            int value = temp1.dequeue();
            q1.enqueue(value);
        }
        while (!temp2.isEmpty()) {
            int value = temp2.dequeue();
            q2.enqueue(value);
        }

        // Check if both queues are empty
        return isEqual && q1.size() == q2.size();
    }


    public static void main(String[] args) {
        ELinkedQueue queue1 = new ELinkedQueue();
        ELinkedQueue queue2 = new ELinkedQueue();

        queue1.enqueue(10);
        queue1.enqueue(20);
        queue2.enqueue(10);
        queue2.enqueue(20);

        System.out.println(equals(queue1, queue2));
    }
}
