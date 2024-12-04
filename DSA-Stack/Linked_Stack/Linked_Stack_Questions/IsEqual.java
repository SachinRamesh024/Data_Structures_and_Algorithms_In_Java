public class IsEqual {
    private Node top;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public IsEqual() {
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

    public int peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return -1;
    }

    public boolean isEqual(IsEqual other) {
        Node current1 = this.top;
        Node current2 = other.top;

        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1 == null && current2 == null;
    }

    public static void main(String[] args) {
        IsEqual stack1 = new IsEqual();
        IsEqual stack2 = new IsEqual();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.push(1);
        stack2.push(2);
        stack2.push(3);

        System.out.println("Are the stacks equal? " + stack1.isEqual(stack2));

        stack2.pop();
        stack2.push(4);

        System.out.println("Are the stacks equal? " + stack1.isEqual(stack2));
    }
}
