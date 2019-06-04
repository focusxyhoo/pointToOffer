package algorithms;

import structure.Node;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-04
 * time        : 19:39
 * description : 这个类中将链表有关各问题汇总起来，给出实现方法。
 * attention   : 链表中没有头节点。
 */
public class AlgorithmsOnLinkedList {

    /**
     * 链表的反转.
     * 不需要考虑链表为空的情况，因为 while 循环已经考虑了。
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        Node cur = head, pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /**
     * 判断链表中是否有环。
     * 方法：设置两个快慢指针，分别遍历链表，若相遇，则说明链表有环，返回 true；否则返回 false。
     *
     * @param head
     * @return
     */
    public static boolean hasCircle(Node head) {
        if (head == null) {
            return false;
        }
        Node fast = head.next;
        Node slow = head;

        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
