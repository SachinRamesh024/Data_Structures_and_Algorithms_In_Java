public class BinaryTree {
    Object root;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(Object root){
        this.root=root;
    }

    public BinaryTree(Object root, BinaryTree left, BinaryTree right){
        this.root=root;
        this.left=left;
        this.right=right;
    }

    public void setRoot(Object root){
        this.root = root;
    }

    public void setLeft(BinaryTree left){
        this.left=left;
    }

    public void setRight(BinaryTree right){
        this.right=right;
    }

    public Object getRoot(){
        return this.root;
    }

    public BinaryTree getLeft(){
        return this.left;
    }

    public BinaryTree getRight(){
        return this.right;
    }

    public String toString(){
        StringBuffer buf = new StringBuffer("");


        //in-order

        if(left!=null)
            buf.append(left + ",");

        buf.append(root);

        if(right!=null)
            buf.append("," +right);

        return buf + "";


        //pre-order
        /*
        buf.append(root);

        if(left!=null)
            buf.append("," +left);

        if(right!=null)
            buf.append("," +right);

        return buf + "";  */


        /*post-order
        if(left!=null)
            buf.append(left + ",");

        if(right!=null)
            buf.append(right + ",");

        buf.append(root);

        return buf +"";*/
    }

    public String inOrderTraversal(){
        StringBuffer buf = new StringBuffer("");

        if(left!=null)
            buf.append(left.inOrderTraversal() + ",");

        buf.append(root);

        if(right!=null)
            buf.append("," +right.inOrderTraversal());

        return buf.toString();
    }

    public String preOrderTraversal(){
        StringBuffer buf = new StringBuffer("");

        buf.append(root);

        if(left!=null)
            buf.append("," +left.preOrderTraversal());

        if(right!=null)
            buf.append("," +right.preOrderTraversal());

        return buf.toString();
    }

    public String postOrderTraversal(){
        StringBuffer buf = new StringBuffer("");

        if(left!=null)
            buf.append(left.postOrderTraversal() +",");

        if(right!=null)
            buf.append(right.postOrderTraversal()+",");

        buf.append(root);

        return buf.toString();
    }

    public boolean isLeaf(){

        return left == null && right == null;
    }

    public int size(){
        if(left == null && right == null)
            return 1;

        if(right==null)
            return 1+left.size();

        if(left==null)
            return 1+ right.size();

        return 1+ left.size() + right.size();
    }

    public int height(){
        if(left == null && right == null)
            return 0;

        if(right == null)
            return 1+left.height();

        if(left== null)
            return 1+right.height();

        return 1+ Math.max(left.height(), right.height());
    }

    public boolean isFullTree(){
        int size = this.size();
        int height = this.height();

        int sizeOfFullTree = (int) Math.pow(2, height + 1) - 1;

        return size == sizeOfFullTree;
    }

    public boolean contains(Object target){
        if(this.root == null)
            return false;

        if(this.root.equals(target))
            return true;

        if(left!=null && this.left.contains(target))
            return true;

        if(right!=null && this.right.contains(target))
            return true;

        return false;
    }


    public static void main(String[] args) {
        //starting from leaves
        BinaryTree D = new BinaryTree("D");
        BinaryTree E = new BinaryTree("E");
        BinaryTree F = new BinaryTree("F");
        BinaryTree B = new BinaryTree("B",D,null);
        BinaryTree C = new BinaryTree("C", E, F);
        BinaryTree A = new BinaryTree("A",B,C);
        //System.out.println("Traversing using toString: "+A);

        System.out.println("In-Order Traversal:   " +A.inOrderTraversal());
        System.out.println("Pre-Order Traversal:  " +A.preOrderTraversal());
        System.out.println("Post-Order Traversal: " +A.postOrderTraversal());

        System.out.println("Tree is Full: " +A.isFullTree());

        System.out.println("Tree contains mentioned node: " +A.contains("B"));
        System.out.println("Tree contains mentioned node: " +A.contains("Z"));


    }
}
