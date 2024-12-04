public class IsEqual {
    private int[] stack;
    private int top;
    private int capacity;

    public IsEqual(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (top < capacity - 1) {
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

    public boolean isEqual(IsEqual other) {
        if (this.top != other.top) {
            return false;
        }

        for (int i = 0; i <= this.top; i++) {
            if (this.stack[i] != other.stack[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsEqual stack1 = new IsEqual(10);
        IsEqual stack2 = new IsEqual(10);

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

