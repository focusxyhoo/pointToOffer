package algorithms;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-23
 * time        : 16:12
 * description :
 */
public class HeapSort {
    public static void main(String[] args) {

        int[] nums = {9, 5, 3, 6, 8, 1, 7, 4, 2};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void heapSort(int[] nums) {
        // 1. 构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            // 从倒数第一个非叶子节点开始，从下往上调整结构
            adjustHeap(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));


        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }


    public static void adjustHeap(int[] nums, int i, int length) {
        // 拿到当前的数组元素
        int temp = nums[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && nums[k] < nums[k + 1]) k++;
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else break;
        }
        nums[i] = temp;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
