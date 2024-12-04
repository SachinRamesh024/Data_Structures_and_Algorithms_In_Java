public class SplitStack {
    private int[] stack;
    private int top;
    private final int size;

    public SplitStack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (top < size - 1) {
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

    public SplitStack[] split() {
        SplitStack half1 = new SplitStack(size / 2 + size % 2);
        SplitStack half2 = new SplitStack(size / 2);

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
        SplitStack stack = new SplitStack(6);

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

