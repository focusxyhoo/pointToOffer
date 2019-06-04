package questions;

public class MinNumberInRotatedArray {
    // 查找和排序问题
    // 一定要能快速、完整、正确地写出各种排序和查找算法
    // 如果要求在已排序（或部分排序）的数组中查找某个数字或统计某个数字的出现次数，即可用二分查找法
    // 哈希表和二叉排序树更多的是考察数据结构，而不是算法
    // 哈希表，效率最高，用空间换时间

    public static int minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        int  mid;

        while (left < right) {
            mid = left + (left + right) / 2;
            if (nums[left] < nums[right]) {
                return nums[left];
            } else if (nums[left] > nums[right]) {
                if (nums[left] > nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[left] > nums[mid]) {
                    right = mid;
                } else if (nums[left] < nums[mid]){
                    left = mid + 1;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(minNumber(nums));
    }
}
