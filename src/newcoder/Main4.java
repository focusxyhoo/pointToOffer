package newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-03
 * time        : 16:18
 * description :
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] nums = new int[n];
        int[] queries = new int[q];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            queries[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < q; i++) {
            change(nums, queries[i]);
        }

    }

    public static void change(int[] nums, int query) {
        int count = 0;
        int low = 0, high = nums.length - 1;
        int index = high;
        while (low <= high) {
            int middle = (high + low) >> 1;
            if (nums[middle] == query) {
                index = middle - 1;
                while (index >= 0 && nums[index] >= query) index--;
                break;
            } else if (nums[middle] < query) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        index++;
        for (int i = index; i < nums.length; i++) {
            nums[i]--;
            count++;
        }
        System.out.println(count);
    }
}
