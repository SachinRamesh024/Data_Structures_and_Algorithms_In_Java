public class ArrayStack {
    private int[] stack;
    private int top;
    public final int size;

    public ArrayStack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int value) {
        if (!isFull()) {
            stack[++top] = value;
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stack[top--];
        }
        return -1;
    }

    public int peek() {
        if (!isEmpty()) {
            return stack[top];
        }
        return -1;
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack as1 = new ArrayStack(5);
    }
}
