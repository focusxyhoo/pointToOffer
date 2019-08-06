package questions;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-12
 * time        : 17:03
 * description :
 */
public class T56_NumbersAppearOnce {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        System.out.println(Arrays.toString(findNumsAppearOnce(nums)));

    }

    public static int findBit1(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        int index = 0;
        while (ans > 0) {
            if ((ans & 1) == 1) return index;
            ans >>= 1;
            index++;
        }
        return -1;
    }

    public static int[] findNumsAppearOnce(int[] nums) {
        if (null == nums || nums.length == 0) return null;
        int[] ans = new int[2];
        int index = findBit1(nums);
        if (index == -1) return null;
        for (int num : nums) {
            if (isBit1(num, index)) ans[1] ^= num;
            else ans[0] ^= num;
        }
        return ans;

    }

    /**
     * 判断 num 的 index 位是否是 1。
     * @param num
     * @param index
     * @return
     */
    private static boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }

}
