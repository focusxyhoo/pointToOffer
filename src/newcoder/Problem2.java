package newcoder;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-29
 * time        : 13:52
 * description :
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        int count = 0;
        for (int i = left; i <= right; i++) {
            int temp = i % 3;
            if (temp == 0 || temp == 2) count++;

        }
        System.out.println(count);
    }

}
