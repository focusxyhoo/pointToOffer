package questions;

import structure.TreeNode;

// 根据二叉树的前序和中序遍历序列来构建二叉树
// 根据中序和后序遍历序列也可以构建出二叉树，但是前序和后序不行
public class ConstructBinaryTree {

    public static TreeNode<Integer> construct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length)
            return null;
        return constructCore(preorder, 0, inorder, 0, preorder.length);

    }

    public static TreeNode<Integer> constructCore(int[] preorder, int preorder_start, int[] inorder, int inorder_start, int length) {
        if (length == 0)
            return null;

        int inorder_index = -1;
        for (int i = inorder_start; i < inorder_start + length; i++) {
            if (inorder[i] == preorder[preorder_start]) {
                inorder_index = i;
                break;
            }
        }
        int left_length = inorder_index - inorder_start;
        TreeNode<Integer> node = new TreeNode<>(preorder[preorder_start]);
        node.left = constructCore(preorder, preorder_start + 1, inorder, inorder_start, left_length);
        node.right = constructCore(preorder, preorder_start + left_length + 1, inorder, inorder_index + 1, length - left_length - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        int key = construct(preorder, inorder).val;
        System.out.println(construct(preorder, inorder));
        System.out.println(key);
    }
}
