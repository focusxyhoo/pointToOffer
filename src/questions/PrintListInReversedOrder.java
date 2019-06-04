package questions;

import java.util.Stack;
import structure.ListNode;

public class PrintListInReversedOrder {
    // 使用栈来实现逆序打印链表的功能
    public static void printListInReversedOrder(ListNode<Integer> p) {
        Stack<Integer> stack = new Stack<>();
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty()) {
            int key = stack.pop();
            System.out.println(key);
        }
    }

    // 也可以使用递归的方法
    public static void printListInReversedOrder1(ListNode<Integer> p) {
        if (p == null)
            return;
        else {
            printListInReversedOrder1(p.next);
            System.out.println(p.val);
        }
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        p.next = new ListNode(2);
        p.next.next = new ListNode(3);

        printListInReversedOrder(p);
        printListInReversedOrder1(p);
    }
}


