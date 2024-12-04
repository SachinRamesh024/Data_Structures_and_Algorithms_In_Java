class BinarySearchTree {

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    BinarySearchTree() {
        root = null;
    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.data) {
            node.left = insertRec(node.left, value);
        } else if (value > node.data) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    boolean search(int value) {
        return searchRec(root, value) != null;
    }

    Node searchRec(Node node, int value) {
        if (node == null || node.data == value)
            return node;

        if (value < node.data)
            return searchRec(node.left, value);

        return searchRec(node.right, value);
    }

    void delete(int value) {
        root = deleteRec(root, value);
    }

    Node deleteRec(Node node, int value) {
        if (node == null)
            return node;

        if (value < node.data)
            node.left = deleteRec(node.left, value);
        else if (value > node.data)
            node.right = deleteRec(node.right, value);
        else {
            // Node with one or no child
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            // Node with two children, get the inorder successor (smallest in the right subtree)
            node.data = minValue(node.right);

            // Delete the inorder successor
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    int minValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    void levelOrder() {
        int height = height(root);
        for (int i = 0; i < height; i++) {
            printLevel(root, i);    // Print nodes at each level
        }
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    void printLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            System.out.print(node.data + " ");
        } else if (level > 0) {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal:");
        bst.inorder();  // Output: 20 30 40 50 60 70 80

        System.out.println("\nPreOrder Traversal");
        bst.preorder();

        System.out.println("\nPostOrder Traversal");
        bst.postorder();

        System.out.println("\nLevelOrder Traversal");
        bst.levelOrder();

        System.out.println("\nSearch 40: " + bst.search(40));  // Output: true

        bst.delete(40);
        System.out.println("Inorder traversal after deleting 40:");
        bst.inorder();  // Output: 20 30 50 60 70 80
    }
}
