package newcoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-29
 * time        : 15:14
 * description :
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
//        System.out.println(s);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.empty() || stack.peek().equals(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (!stack.peek().equals(s.charAt(i))) {
                stack.pop();
            }
        }
        if (stack.empty()) System.out.println('N');
        else {
            int count = 0;
            char flag = stack.peek();
            while (!stack.empty()) {
                stack.pop();
                count++;
            }
            int temp = count % 4;

            if (temp == 0) System.out.println('N');
            else if (temp == 2) System.out.println('S');
            else if (flag == 'L') {
                if (temp == 1) System.out.println('W');
                else System.out.println('E');
            } else {
                if (temp == 1) System.out.println('E');
                else System.out.println('W');
            }
        }


    }
}
