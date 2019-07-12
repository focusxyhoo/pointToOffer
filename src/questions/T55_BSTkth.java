package questions;

/**
 * 题目：给定一个二叉搜索树 BST 和一个整数 k，找出树中第 k 大的节点。
 * BST 的中序遍历即是排序好的，因此按中序遍历的顺序来递减 k 即可。
 */
public class T55_BSTkth {

    private static class Node {
        int value;
        Node left, right;

        Node(int v) {
            value = v;
            left = null;
            right = null;
        }
    }

    private static int index; // 利用类变量来共享值。

    public static Node getKthNode(Node root, int k) {
        if (root == null || k == 0) return null; // 一定不要忘了极端条件。
        index = k;
        return core(root);
    }

    private static Node core(Node root) {
        Node target = null; // 利用 target 变量来保存要找的节点，当期不为空时，结束其他查找。
        if (root.left != null)
            target = core(root.left);

        if (target == null) {
            if (index == 1) target = root;
            index--;
        }

        if (target == null && root.right != null) {
            target = core(root.right);
        }
        return target;
    }

    /**
     * 递归中序遍历的写法。检验。
     *
     * @param root
     */
    public static void inOrder(Node root) {

        if (root.left != null)
            inOrder(root.left);

        System.out.println(root.value);

        if (root.right != null)
            inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        inOrder(root);
        System.out.println(getKthNode(root, 1).value);
    }
}