package questions;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-22
 * time        : 10:00
 * description :
 */
public class T57_TwoNumbersWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 11, 15};
        System.out.println(Arrays.toString(findNumbersWithSum(nums, 15)));

    }

    public static int[] findNumbersWithSum(int[] nums, int sum) {
        if (null == nums || nums.length == 0) return null;

        // 数组长度为 1 的情况也在其中。
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int temp = nums[low] + nums[high];
            if (temp == sum) break;
            else if (temp < sum) low++;
            else high--;
        }

        if (low >= high) return null;
        else return new int[]{nums[low], nums[high]};
    }
}
