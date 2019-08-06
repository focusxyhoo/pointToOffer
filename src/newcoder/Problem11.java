package newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-30
 * time        : 14:37
 * description :
 */
public class Problem11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] apple = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
            apple[i] = sum;
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println(findIndex(apple, scanner.nextInt()));
        }
    }

    private static int findIndex(int[] nums, int m) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high + 1) / 2;
            if (m < nums[middle]) high = middle - 1;
            else if (m > nums[middle]) low = middle + 1;
            else return middle + 1;
        }
        return Math.max(low + 1, high + 1);
    }

}
