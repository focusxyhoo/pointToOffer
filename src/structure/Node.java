package structure;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-04
 * time        : 19:43
 * description : 数据类型为 int 的节点类。相比 ListNode 类取消了泛型，实现更加简单。
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
