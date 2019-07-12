package questions;
/**
 * 查找有序数组中数字的出现次数。
 * 若扫描一遍进行同济，时间复杂度为 O(n)，不是我们想要的。
 * 这里采用二分查找法，分别查找该数字在有序数组中第一次和最后一次出现的位置（时间复杂度均为 O(logn)），
 * 因此总的时间复杂度也为 O(logn)。
 */

public class T53_NumberOfK {

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,3,4,5};
        System.out.println(getNumberOfK(nums, 3));
    }

    public static int getNumberOfK(int[] nums, int k) {
        int ans = 0;
        if (nums == null || nums.length == 0) return ans;
        int firstIndex = getFirstK(nums, k, 0, nums.length - 1);
        int lastIndex = getLastK(nums, k, 0, nums.length - 1);
        if (firstIndex > -1 && lastIndex > -1) ans = lastIndex - firstIndex + 1;
        return ans;
    }

    private static int getFirstK(int[] nums, int k, int start, int end) {
        if (start > end) return -1;
        int middleIndex = (start + end) / 2;
        int middleData = nums[middleIndex];
        if (middleData == k) {
            if ((middleData > 0 && nums[middleIndex - 1] != k) || middleIndex == 0)
                return middleIndex;
            else end = middleIndex - 1;
        } else if (middleData > k)
            end = middleIndex - 1;
        else start = middleIndex + 1;
        return getFirstK(nums, k, start, end);
    }

    private static int getLastK(int[] nums, int k, int start, int end) {
        if (start > end) return -1;
        int middleIndex = (start + end) / 2;
        int middleData = nums[middleIndex];
        if (middleData == k) {
            if (middleData == nums.length - 1 || (middleIndex < nums.length - 1 && nums[middleIndex + 1] != k))
                return middleIndex;
            else start = middleIndex + 1;
        } else if (middleData < k)
            start = middleIndex + 1;
        else end = middleIndex - 1;
        return getLastK(nums, k, start, end);
    }
}