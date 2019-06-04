package questions;

import algorithms.QuickSort;

/**
 * @author focusxyhoo
 * @description 输入 n 个整数，找出其中最小的 k 个数
 * 排序之后很容易得出结果，但时间复杂度为 O(nlogn)
 * @date 2019-05-28 20:27
 */
public class T40_KLeastNumbers {

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        getKLeastNumbers3(nums, k);
    }

    /**
     * 递归思想
     * 同样是借助快速排序中的 partition 函数，找出前 k 小的数字
     * 缺点：会修改原来的数组
     * 优点：时间复杂度为 O(n)
     *
     * @param nums
     * @param k
     */
    public static void getKLeastNumbers(int[] nums, int k) {
        if (isInvalidInput(nums, k)) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        int index = QuickSort.quickSortPartition(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                index = QuickSort.quickSortPartition(nums, start, index - 1);
            } else {
                index = QuickSort.quickSortPartition(nums, index + 1, end);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 在学习堆的时候就清楚：堆非常适合用来在大量数据中查找前 k 大/小的数
     * 思路：设计一个大小为 k 的容器，遍历数组 nums， 在容器没填满之前，将读取的数字加入容器
     * 在容器填满后，每读取一个数字，将其与容器中的最大值进行比较，若小，则替换，若大，则读取下一个
     * 这个容器就可以考虑采用最小堆或者红黑树
     * 时间复杂度为 O(nlogk)
     *
     * @param nums
     * @param k
     */
    public static void getKLeastNumbers2(int[] nums, int k) {
        if (isInvalidInput(nums, k)) {
            return;
        }
        // 在 Java 中如何创建堆/红黑树？
        int[] heap = new int[k + 1];

    }

    /**
     * 选择排序
     * 遍历 k 遍数组，每次挑出最小的数字，然后再在剩下的元素中继续遍历
     * 时间复杂度为 O(n*k)
     * 适合 k 比较小的情况
     *
     * @param nums
     * @param k
     */
    public static void getKLeastNumbers3(int[] nums, int k) {
        if (isInvalidInput(nums, k)) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                System.out.print(nums[minIndex] + " ");
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
    }

    private static boolean isInvalidInput(int[] nums, int k) {
        return null == nums || k > nums.length || nums.length <= 0 || k <= 0;
    }

}