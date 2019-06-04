package algorithms;

import java.util.List;

public class QuickSort {
    // 快速排序的三种实现方式

    // 数组快速排序
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        quickSortCore(nums, 0, nums.length - 1);
    }

    private static void quickSortCore(int[] nums, int start, int end) {
        if (end - start <= 0)
            return;
        int index = quickSortPartition(nums, start, end);
        quickSortCore(nums, start, index - 1);
        quickSortCore(nums, index + 1, end);
    }

    /**
     * 找出数组中 nums[left] 元素的正确位置
     * 快速排序的基础，同时也可以用来查找 n 个数中第 k 大的数字
     *
     * @param nums  待排序的数组
     * @param left  左下标
     * @param right 右下标
     * @return 返回 nums[left] 在数组中的正确位置
     */
    public static int quickSortPartition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            while (left < right && nums[left] < pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
        }
        nums[left] = pivot;
        return left;
    }

    public static void testQuickSort(int[] nums) {
        quickSort(nums);
        System.out.print("数组快速排序：");
        for (int item : nums) {
            System.out.print(item);
            System.out.print("  ");
        }
        System.out.println();
    }

    // 内置链表快速排序
    public static void quickSortList(List<Integer> nums) {
        if (nums == null || nums.size() < 2)
            return;

    }

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49};
        System.out.print("排序前：");
        for (int item : nums) {
            System.out.print(item);
            System.out.print("  ");
        }
        System.out.println();
        testQuickSort(nums);
    }
}
