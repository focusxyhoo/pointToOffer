package questions;

public class DuplicationInArrayNoEdit {
    public static int duplicationInArrayNoEdit(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int length = nums.length;
        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = countRange(nums, start, mid);
            if (start == end) {
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count > (mid - start + 1))
                end = mid;
            else
                start = mid + 1;
        }
        return -1;
    }
    private static int countRange(int[] nums, int start, int end) {
        if (nums == null)
            return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(duplicationInArrayNoEdit(nums));
    }
}
