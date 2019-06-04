package structure;

import java.util.Stack;

class QueueWithTwoStacks<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void appendTail(T target) {
        // 需要额外判断栈满的情况
        stack1.push(target);
    }

    public T deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                // 这里加入了判断栈空时弹出元素的警告
                System.out.println("队列为空，请先添加元素！");
                return null;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

class QueueDemo {
    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> myQueue = new QueueWithTwoStacks<>();
        myQueue.appendTail(1);
        myQueue.appendTail(2);
        System.out.println(myQueue.deleteHead());
        myQueue.appendTail(3);
        myQueue.appendTail(4);
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
    }
}

