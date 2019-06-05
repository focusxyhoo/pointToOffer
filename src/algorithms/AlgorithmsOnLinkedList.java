package algorithms;

import structure.Node;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-04
 * time        : 19:39
 * description : 这个类中将链表有关各问题汇总起来，给出实现方法。
 * 链表中没有头节点。
 * 原地修改，会影响原链表。
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


    /**
     * 合并两个有序链表。
     *
     * @param la
     * @param lb
     * @return
     */
    public static Node mergeSortedLists(Node la, Node lb) {
        // 优先处理链表为空的情况。
        if (la == null) return lb;
        if (lb == null) return la;

        Node p = la, q = lb;
        Node head;
        if (p.value < q.value) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;

        while (p != null && q != null) {
            if (p.value < q.value) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }
        return head;
    }

    /**
     * 返回链表倒数第 k 个节点。
     * 两次遍历链表。时间复杂度 O(n^2)
     *
     * @param head
     * @param k
     * @return
     */
    public static Node getLastKthNode(Node head, int k) {
        int length = getLength(head);
        Node cur = head;
        if (k > length) return null;
        for (int i = 1; i < length - k + 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private static int count;

    /**
     * 返回链表倒数第 k 个节点。
     * 递归。时间复杂度 O(n^2)
     * 注意这里 count 必须是类的成员变量。
     *
     * @param head
     * @param k
     * @return
     */
    public static Node getLastKthNodeRecursively(Node head, int k) {
        count = k;
        if (head == null) return null;
        Node cur = getLastKthNodeRecursively(head.next, k);
        if (cur != null) {
            return cur;
        } else {
            count--;
            if (count == 0) return head;
            return null;
        }
    }

    /**
     * 返回链表倒数第 k 个节点。
     * 利用两个指针，一次遍历。
     *
     * @param head
     * @param k
     * @return
     */
    public static Node getLastKthNodeOne(Node head, int k) {
        if (head == null || k == 0) return null;
        Node p = head, q = head;
        for (int i = 0; i < k; i++) {
            if (p != null) {
                p = p.next;
            } else return null;
        }
        while (p != null) {
            p=p.next;
            q=q.next;
        }
        return q;
    }


    /**
     * 删除倒数第 k 个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static Node deleteLastKthNode(Node head, int k) {
        return head;
    }

    /**
     * 返回链表的长度。一次遍历。
     *
     * @param head
     * @return
     */
    public static int getLength(Node head) {
        Node cur = head;
        int length = 0;
        while (cur != null) {
            ++length;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 打印链表的节点。
     *
     * @param head
     * @return
     */
    public static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 新建两个链表 1 -> 5 -> 7 -> null 和 2 -> 4 -> null
        Node la = new Node(1);
        la.next = new Node(5);
        la.next.next = new Node(7);
        Node lb = new Node(2);
        lb.next = new Node(4);

        // 打印链表 la 和 lb
        System.out.print("链表 la：");
        printList(la);

        System.out.print("链表 lb：");
        printList(lb);

        System.out.println("链表 la 的长度：" + getLength(la));

//        Node pre = reverse(la);
//        System.out.print("反转链表 la：");
//        printList(pre);

        // 新建一个有环的链表：3 -> 6 -> 9 -> 3 ...
        Node lc = new Node(3);
        lc.next = new Node(6);
        lc.next.next = new Node(9);
        lc.next.next.next = lc;

        System.out.println("链表 la 是否有环：" + hasCircle(la));
        System.out.println("链表 lc 是否有环：" + hasCircle(lc));

//        Node head = mergeSortedLists(la, lb);
//        System.out.print("合并有序链表 la 和 lb：");
//        printList(head);

//        Node k = getLastKthNode(la, 2);
//        System.out.println("链表 la 倒数第 2 个节点是：" + k.value);
        Node v = getLastKthNodeOne(la, 2);
        System.out.println("一次遍历：链表 la 倒数第 2 个节点是：" + v.value);


    }
}
