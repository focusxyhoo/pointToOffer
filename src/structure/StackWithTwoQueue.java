package structure;

import java.util.LinkedList;
import java.util.Queue;

// 用两个队列实现栈
class StackWithTwoQueue<T> {
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public void push(T target) {
        if (queue2.isEmpty())
            queue1.add(target);
        else
            queue2.add(target);
    }

    public T pop() {
        if (!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        } else if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        } else
            return null;
    }
}

// 用一个队列实现栈
class StackWithOneQueue<T> {
    private Queue<T> queue = new LinkedList<>();

    public void push(T target) {
        queue.add(target);
    }

    public T pop() {
        if (queue.isEmpty()) {
            return null;
        } else {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.poll());
            }
            return queue.poll();
        }
    }
}

class StackDemo {
    public static void main(String[] args) {
        StackWithTwoQueue<Integer> myStack = new StackWithTwoQueue<>();
        StackWithOneQueue<Character> myStack1 = new StackWithOneQueue<>();
        myStack.push(1);
        System.out.println(myStack.pop());
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

        myStack1.push('a');
        myStack1.push('b');
        myStack1.push('c');
        System.out.println(myStack1.pop());
        myStack1.push('d');
        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
    }


}
