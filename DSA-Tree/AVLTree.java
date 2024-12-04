public class AVLTree {
    int key, height;
    AVLTree left, right;
    public static final AVLTree nill = new AVLTree();

    AVLTree() {
        left = right = this;
        height = -1;
    }

    public AVLTree(int key) {
        this.key = key;
        left = right = nill;
        height = 0;
    }

    private AVLTree(int key, AVLTree left, AVLTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 1 + Math.max(left.height, right.height);
    }

    public int size() {
        if (this == nill) {
            return 0;
        }
        return 1 + left.size() + right.size();
    }

    public String toString() {
        if (this == nill) {
            return "";
        }
        return left.toString() +" "+ key +" "+ right.toString();  // In-order traversal in tree
    }

    public boolean add(int key) {
        int oldsize = size();
        grow(key);
        return size() > oldsize;
    }

    public AVLTree grow(int key) {
        if (this == nill)
            return new AVLTree(key);

        if (key == this.key)
            return this;  // Prevent duplication

        if (key < this.key)
            left = left.grow(key);
        else
            right = right.grow(key);

        rebalance();

        height = 1 + Math.max(left.height, right.height);
        return this;
    }

    public void rebalance() {
        if (right.height > left.height + 1) {
            if (right.left.height > right.right.height) {
                right.rotateRight();
            }
            rotateLeft();
        }

        if (left.height > right.height + 1) {
            if (left.right.height > left.left.height) {
                left.rotateLeft();
            }
            rotateRight();
        }
    }
    private void rotateLeft() {
        AVLTree newLeft = new AVLTree(key, left, right.left);
        key = right.key;
        right = right.right;
        left = newLeft;
    }
    private void rotateRight() {
        AVLTree newRight = new AVLTree(key, left.right, right);
        key = left.key;
        left = left.left;
        right = newRight;
    }

    public static void main(String[] args) {

        AVLTree b1 = new AVLTree(10);
        b1.add(0);
        b1.add(12);
        b1.add(18);
        b1.add(40);

        System.out.println( b1.toString());
        System.out.println(b1.size());
    }
}

