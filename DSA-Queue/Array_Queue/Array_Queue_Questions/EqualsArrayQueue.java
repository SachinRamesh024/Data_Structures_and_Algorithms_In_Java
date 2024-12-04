class EArrayQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public EArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        size = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = queue[front];
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    public int size() {
        return size;
    }
}

public class EqualsArrayQueue {
    public static boolean equals(EArrayQueue q1, EArrayQueue q2) {
        if (q1.isEmpty() && q2.isEmpty()) {
            return true;
        }

        if (q1.isEmpty() || q2.isEmpty()) {
            return false;
        }

        EArrayQueue temp1 = new EArrayQueue(q1.size());
        EArrayQueue temp2 = new EArrayQueue(q2.size());

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

        while (!temp1.isEmpty()) {
            q1.enqueue(temp1.dequeue());
        }
        while (!temp2.isEmpty()) {
            q2.enqueue(temp2.dequeue());
        }

        return isEqual;
    }

    public static void main(String[] args) {
        EArrayQueue queue1 = new EArrayQueue(5);
        EArrayQueue queue2 = new EArrayQueue(5);

        queue1.enqueue(10);
        queue1.enqueue(20);
        queue2.enqueue(10);
        queue2.enqueue(20);

        System.out.println(equals(queue1, queue2));
    }
}

