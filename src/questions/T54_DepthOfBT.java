package questions;

public class T54_DepthOfBT {

    private static class Node {
        int value;
        Node left, right;

        public Node(int v) {
            value = v;
            left = null;
            right = null;
        }
    }

    public static int getHeight(Node root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    /**
     * 太多重复的调用，效率较低。
     *
     * @param root
     * @return
     */
    public static boolean isBalancedRecursively(Node root) {

        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int diff = leftHeight - rightHeight;
        if (diff < -1 || diff > 1) return false;
        return isBalancedRecursively(root.left) && isBalancedRecursively(root.right);
    }

    public static boolean isBalancedPostOrder(Node root) {
        if (root == null) {
            return true;
        }

        return isBalancedCore(root, new int[]{0});
    }

    /**
     * 利用后序遍历，通过数组将子节点的高度传递给父节点。
     * Java 中有没有其他方法可以在递归调用中传递参数？
     * 实例变量。
     *
     * @param root
     * @param depth
     * @return
     */
    private static boolean isBalancedCore(Node root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[]{0};
        int[] right = new int[]{0};
        if (isBalancedCore(root.left, left) && isBalancedCore(root.right, right)) {
            int diff = right[0] - left[0];
            if (diff <= 1 && diff >= -1) {
                depth[0] = 1 + (right[0] > left[0] ? right[0] : left[0]);
                return true;
            } else return false;
        }
        return false;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);

        System.out.println(getHeight(root));
    }

}