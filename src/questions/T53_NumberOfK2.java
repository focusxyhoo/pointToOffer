package questions;

public class T53_NumberOfK2 {

    public static void main(String[] args) {

        int[] nums = {0, 1, 3, 4, 5, 6};
        System.out.println(getMissingNumber(nums));
    }

    public static int getMissingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == middle) {
                start = middle + 1;
            } else {
                if (middle == 0 || nums[middle - 1] == middle - 1)
                    return middle;
                end = middle - 1;
            }
        }
        if (start == nums.length) return nums.length;
        return -1;
    }
}
