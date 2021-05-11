/**
 * 2021-05-10 Mon
 * */
public class Leet034 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int start = greaterOrEqual(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1, -1};
        return new int[]{start, greaterOrEqual(nums, target + 1) - 1};
    }

    private int greaterOrEqual(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l] >= target ? l : nums.length;
    }
}
