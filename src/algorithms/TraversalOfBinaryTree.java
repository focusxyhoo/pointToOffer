package algorithms;

import structure.TreeNode;

import java.util.*;

// 二叉树的遍历
public class TraversalOfBinaryTree {

    // 前序递归遍历
    public static List<Integer> preorderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null)
            return list;
        list.add(node.val);
        list.addAll(preorderRecursively(node.left));
        list.addAll(preorderRecursively(node.right));
        return list;
    }

    // 中序递归遍历
    public static List<Integer> inorderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null)
            return list;
        list.addAll(inorderRecursively(node.left));
        list.add(node.val);
        list.addAll(inorderRecursively(node.right));
        return list;
    }

    // 后序递归遍历
    public static List<Integer> postorderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null)
            return list;
        list.addAll(postorderRecursively(node.left));
        list.addAll(postorderRecursively(node.right));
        list.add(node.val);
        return list;
    }

    // 前序非递归遍历
    public static List<Integer> preorderIteractively(TreeNode<Integer> node) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        List<Integer> list = new LinkedList<>();
        if (node == null)
            return list;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop().right;
            }
        }
        return list;
    }

    // 中序非递归遍历
    public static List<Integer> inorderIteractively(TreeNode<Integer> node) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        List<Integer> list = new LinkedList<>();
        if (node == null)
            return list;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                list.add(stack.peek().val);
                cur = stack.pop().right;
            }
        }
        return list;
    }

    // 后序非递归遍历
    public static List<Integer> postorderIteractively(TreeNode<Integer> node) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        List<Integer> list = new LinkedList<>();
        TreeNode<Integer> preVisted = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek().right;
                if (cur != null && cur != preVisted) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    preVisted = stack.pop();
                    list.add(preVisted.val);
                    cur = null;
                }
            }
        }
        return list;
    }

    // 层序遍历 BFS
    public static List<Integer> levelorder(TreeNode<Integer> node) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        TreeNode<Integer> temp = null;
        if (node == null)
            return list;
        queue.offer(node);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return list;
    }

    public static void main(String[] args) {
        //                1
        //               / \
        //              2   3
        //             /   / \
        //            4   5   6
        //             \     /
        //              7   8
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.left.right = new TreeNode<>(7);
        root.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.right.left = new TreeNode<>(8);

        List<Integer> list_preorderRecursively = preorderRecursively(root);
        System.out.print("Preorder recursively: ");
        System.out.println(list_preorderRecursively.toString());

        List<Integer> list_inorderRecursively = inorderRecursively(root);
        System.out.print("Inorder recursively: ");
        System.out.println(list_inorderRecursively.toString());

        List<Integer> list_postorderRecursively = postorderRecursively(root);
        System.out.print("Postorder recursively: ");
        System.out.println(list_postorderRecursively.toString());

        List<Integer> list_preorderIteractively = preorderIteractively(root);
        System.out.print("Preorder iteractively: ");
        System.out.println(list_preorderIteractively.toString());

        List<Integer> list_inorderIteractively = inorderIteractively(root);
        System.out.print("Inorder iteractively: ");
        System.out.println(list_inorderIteractively.toString());

        List<Integer> list_postorderIteractively = postorderIteractively(root);
        System.out.print("Postorder iteractively: ");
        System.out.println(list_postorderIteractively.toString());

        List<Integer> list_levelorder = levelorder(root);
        System.out.print("Levelorder: ");
        System.out.println(list_levelorder.toString());
    }
}
