public class MergeStacks {
    private int[] stack;
    private int top;
    private final int size;

    public MergeStacks(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
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

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static MergeStacks merge(MergeStacks stack1, MergeStacks stack2) {
        MergeStacks merged = new MergeStacks(stack1.size + stack2.size);
        MergeStacks temp = new MergeStacks(stack1.size + stack2.size);

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
        MergeStacks stack1 = new MergeStacks(5);
        MergeStacks stack2 = new MergeStacks(5);

        stack1.push(1);
        stack1.push(2);
        stack2.push(3);
        stack2.push(4);

        MergeStacks merged = merge(stack1, stack2);
        System.out.println("Merged Stack:");
        merged.display();
    }
}

