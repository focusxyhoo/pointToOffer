package newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-29
 * time        : 21:57
 * description :
 */
public class Problem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long w = scanner.nextInt();
        long[] food = new long[n];
        for (int i = 0; i < n; i++) {
            food[i] = scanner.nextInt();
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += food[i];
        }
        if (sum <= w) {
            System.out.println((int)Math.pow(2, n));
            return;
        }

        System.out.println(loop(food, n - 1, w));
    }

    private static int loop(long[] nums, long i, long w) {
        if (i == 0) {
            if (w >= nums[0]) return 2;
            else return 1;
        }
        if (w == 0) return 1;
        if (w - nums[(int) i] >= 0) return loop(nums, i - 1, w - nums[(int) i]) + loop(nums, i - 1, w);
        else return loop(nums, i - 1, w);
    }
}
