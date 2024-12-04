public class SplitStack {
    private Node top;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public SplitStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (!isEmpty()) {
            int value = top.data;
            top = top.next;
            return value;
        }
        return -1;
    }

    public void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public SplitStack[] split() {
        SplitStack half1 = new SplitStack();
        SplitStack half2 = new SplitStack();

        int count = 0;
        while (!isEmpty()) {
            if (count % 2 == 0) {
                half1.push(pop());
            } else {
                half2.push(pop());
            }
            count++;
        }
        return new SplitStack[]{half1, half2};
    }

    public static void main(String[] args) {
        SplitStack stack = new SplitStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        SplitStack[] halves = stack.split();
        System.out.println("First Half:");
        halves[0].display();
        System.out.println("Second Half:");
        halves[1].display();
    }
}

