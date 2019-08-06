package questions;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-12
 * time        : 20:52
 * description :
 */
public class T56_NumberAppearOnce {
    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, 2, 3, 3, 3};
        System.out.println(0 << 1);
        System.out.println(findNumberAppearOnce(nums));

    }

    public static int findNumberAppearOnce(int[] nums) {

        if (null == nums || nums.length == 0) return -1;

        // 不能通过除 2 得余来获得其二进制，因为对负数不可行。
        int[] bits = new int[32];
        for (int num : nums) {
            int bitMask = 1;
            for (int i = 31; i >= 0; i--) {
                int bit = num & bitMask;
                if (bit != 0) bits[i] += 1;
                bitMask <<= 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; // 只能左移
            result += bits[i] % 3;
        }
        return result;
    }

}
