public class MergeStacks {
    private Node top;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public MergeStacks() {
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

    public static MergeStacks merge(MergeStacks stack1, MergeStacks stack2) {
        MergeStacks temp = new MergeStacks();
        MergeStacks merged = new MergeStacks();

        while (!stack1.isEmpty()) {
            temp.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            temp.push(stack2.pop());
        }
        while (!temp.isEmpty()) {
            merged.push(temp.pop());
        }
        return merged;
    }

    public static void main(String[] args) {
        MergeStacks stack1 = new MergeStacks();
        MergeStacks stack2 = new MergeStacks();

        stack1.push(1);
        stack1.push(2);
        stack2.push(3);
        stack2.push(4);

        MergeStacks merged = merge(stack1, stack2);
        System.out.println("Merged Stack:");
        merged.display();
    }
}

