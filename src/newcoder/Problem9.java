package newcoder;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-29
 * time        : 22:45
 * description :
 */
public class Problem9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] pos = new int[m];
        for (int i = 0; i < m; i++) {
            pos[i] = scanner.nextInt();
        }

        int[] result = new int[n + 1];
        for (int i = 0; i < m; i++) {
            result[pos[i]]++;
        }
        System.out.println(getMin(result));
    }

    private static int getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            min = nums[i] < min ? nums[i] : min;
        }
        return min;
    }
}
