package questions;


import algorithms.QuickSort;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，找出这个数字
 * 排序之后，马上就能得到结果，时间复杂度是 O(nlogn)
 *
 * @author focusxyhoo
 * @date 2019-05-28 19:07
 */
public class P39_MoreThanHalfNumber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] error = {1, 1, 1, 1, 2, 3, 4, 5};
        System.out.println(moreThanHalfNumber(nums));
        System.out.println(moreThanHalfNumber(error)); // 很明显这个结果是错误的
//        System.out.println(8 >>> 1);
        System.out.println(moreThanHalfNumber2(nums));
        System.out.println(moreThanHalfNumber2(error));

    }

    /**
     * 将问题转化为求 topK 问题，此处为求第 k 小的值
     * 注意条件：数组中有一个数字出现的次数超过了数组长度的一半，这意味着
     * 排序后处于数组中间的数字一定就是我们要找的那个数字
     * 利用快速排序中的分区函数解决问题
     * 时间复杂度为 O(n)，暂时还没理解
     *
     * @param nums
     * @return
     */
    public static int moreThanHalfNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        // 无符号右移，9 >>> 1 即等价于 1001 >>> 1 等于 4
        // 除了负整数除以2等于其右移1位加1外，所有整数除以2与右移1位等价
        // 注意负数的二进制表示
        int k = nums.length >>> 1;
        // 注意 index 的含义：nums[left] 在数组中的正确位置
        int index = QuickSort.quickSortPartition(nums, left, right);
        while (index != k) {
            if (index > k) {
                index = QuickSort.quickSortPartition(nums, left, index - 1);
            } else {
                index = QuickSort.quickSortPartition(nums, index + 1, right);
            }
        }
        if (isIllegal(nums, nums[k])) {
            return nums[k];
        } else return 0;

    }

    /**
     * 判断 number 在数组中出现的次数是否超过数组长度的一半
     * 若没有，则表示输入出错，返回 0
     *
     * @param nums
     * @param number
     * @return
     */
    private static boolean isIllegal(int[] nums, int number) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number) {
                count++;
            }
        }
        if (2 * count <= nums.length) {
            return false;
        }
        return true;
    }


    /**
     * 根据数组特点来解决
     * 在遍历数组的同时，保存两个值：数组中的一个数字，以及其次数
     * 规则：当当前数字与之前保存的数字不相同时，次数减一；当相同时，次数加一；当次数为零时，保存当前数字，次数重新设为一
     * 只遍历了一遍数组，因此时间复杂度为 O(n)
     *
     * @param nums
     * @return
     */
    public static int moreThanHalfNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
            } else if (result == nums[i]) {
                count++;
            } else count--;
        }
        if (isIllegal(nums, result)) {
            return result;
        } else return 0;
    }
}
