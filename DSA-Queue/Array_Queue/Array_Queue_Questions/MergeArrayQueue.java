class ArrayQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public ArrayQueue(int capacity) {
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

public class MergeArrayQueue {
    public static ArrayQueue mergeQueues(ArrayQueue q1, ArrayQueue q2, int capacity) {
        ArrayQueue mergedQueue = new ArrayQueue(capacity);

        while (!q1.isEmpty()) {
            mergedQueue.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            mergedQueue.enqueue(q2.dequeue());
        }
        return mergedQueue;
    }

    public static void main(String[] args) {
        ArrayQueue queue1 = new ArrayQueue(5);
        ArrayQueue queue2 = new ArrayQueue(5);

        queue1.enqueue(10);
        queue1.enqueue(20);
        queue2.enqueue(30);
        queue2.enqueue(40);

        ArrayQueue mergedQueue = mergeQueues(queue1, queue2, 10);

        while (!mergedQueue.isEmpty()) {
            System.out.println(mergedQueue.dequeue());
        }
    }
}
