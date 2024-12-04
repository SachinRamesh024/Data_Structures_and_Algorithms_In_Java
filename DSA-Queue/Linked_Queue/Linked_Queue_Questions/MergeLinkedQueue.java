class LinkedQueue {
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

    public LinkedQueue() {
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
            tail = newNode;
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

public class MergeLinkedQueue {
    public static LinkedQueue mergeQueues(LinkedQueue q1, LinkedQueue q2) {
        LinkedQueue mergedQueue = new LinkedQueue();

        while (!q1.isEmpty()) {
            mergedQueue.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            mergedQueue.enqueue(q2.dequeue());
        }
        return mergedQueue;
    }

    public static void main(String[] args) {
        LinkedQueue queue1 = new LinkedQueue();
        LinkedQueue queue2 = new LinkedQueue();

        queue1.enqueue(10);
        queue1.enqueue(20);
        queue2.enqueue(30);
        queue2.enqueue(40);

        LinkedQueue mergedQueue = mergeQueues(queue1, queue2);

        while (!mergedQueue.isEmpty()) {
            System.out.println(mergedQueue.dequeue());
        }
    }
}
