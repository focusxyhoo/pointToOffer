package questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-22
 * time        : 15:28
 * description :
 */
public class T59_MaxInSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(Arrays.toString(maxInWindows(nums, 3)));

    }

    public static int[] maxInWindows(int[] nums, int n) {
        int[] result = new int[nums.length - n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nums[0]);
        int currMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (queue.size() < 3) {
                queue.offer(nums[i]);
                currMax = currMax < nums[i] ? nums[i] : currMax;
            } else {
                queue.remove();
                queue.offer(nums[i]);
                result[i - n] = currMax;
                currMax = currMax < nums[i] ? nums[i] : currMax;
            }
        }
        return result;
    }
}
