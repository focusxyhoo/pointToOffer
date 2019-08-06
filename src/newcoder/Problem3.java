package newcoder;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-29
 * time        : 14:41
 * description :
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n;i++) {
            int len = scanner.nextInt();
            String s = scanner.next(); // 注意这里用 next 和 nextLine 效果是不一样的。
            // 这是因为，上面的 nextInt 只会读取数值，其后的回车符号被 nextLine 读取到直接结束，读进去的是一个空行。
            // 而 next 对输入有效字符之前的空白符会自动清除，直到读取到有效字符，并遇到空白符后结束。
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) == '.') {
                    count++;
                    j += 2;
                }
            }
            System.out.println(count);
        }
    }

}
