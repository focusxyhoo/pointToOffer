package questions;

public class NextNodeInBinaryTree {

    public static TreeNode<Character> getNextNode(TreeNode<Character> node) {
        if (node == null)
            return null;
        if (node.right != null)
            return findLeftest(node.right);
        else {
            TreeNode<Character> curNode = node;
            while (true) {
                if (curNode.father == null)
                    return null;
                else if (curNode.father.left == curNode)
                    return curNode.father;
                else
                    curNode = curNode.father;
            }
        }
    }

    public static TreeNode<Character> findLeftest(TreeNode<Character> node) {
        if (node.left == null)
            return node;
        else
            return findLeftest(node.left);
    }

    public static void main(String[] args) {
        TreeNode<Character> root = new TreeNode<>('a');
        root.left = new TreeNode<>('b');
        root.left.father = root;
        root.right = new TreeNode<>('c');
        root.right.father = root;
        root.left.left = new TreeNode<>('d');
        root.left.left.father = root.left;
        root.left.right = new TreeNode<>('e');
        root.left.right.father = root.left;
        root.right.left = new TreeNode<>('f');
        root.right.left.father = root.right;
        root.right.right = new TreeNode<>('g');
        root.right.right.father = root.right;
        root.left.right.left = new TreeNode<>('h');
        root.left.right.left.father = root.left.right;
        root.left.right.right = new TreeNode<>('i');
        root.left.right.right.father = root.left.right;


        System.out.println("The next node of \"" + root.val + "\" is: " + getNextNode(root).val + ". ");
        System.out.println("The next node of \"" + root.left.val + "\" is: " + getNextNode(root.left).val + ". ");
        System.out.println("The next node of \"" + root.right.val + "\" is: " + getNextNode(root.right).val + ". ");
        System.out.println("The next node of \"" + root.left.left.val + "\" is: " + getNextNode(root.left.left).val + ". ");
        System.out.println("The next node of \"" + root.left.right.val + "\" is: " + getNextNode(root.left.right).val + ". ");
        System.out.println("The next node of \"" + root.right.left.val + "\" is: " + getNextNode(root.right.left).val + ". ");
        if (getNextNode(root.right.right) == null)
            System.out.println("The next node of \"" + root.right.right.val + "\" is: null. ");
        System.out.println("The next node of \"" + root.left.right.left.val + "\" is: " + getNextNode(root.left.right.left).val + ". ");
        System.out.println("The next node of \"" + root.left.right.right.val + "\" is: " + getNextNode(root.left.right.right).val + ". ");
    }
}

class TreeNode<T> {
    public T val;
    TreeNode<T> right;
    TreeNode<T> left;
    TreeNode<T> father;

    public TreeNode(T val) {
        this.val = val;
        this.right = null;
        this.left = null;
        this.father = null;
    }
}
