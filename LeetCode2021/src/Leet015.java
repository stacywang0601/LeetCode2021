import java.util.*;

public class Leet015 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;

            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;

                int l = i + 1, h = nums.length - 1;
                while (l < h) {
                    if (nums[l] + nums[h] < -nums[i]) {
                        l++;
                    } else if (nums[l] + nums[h] > -nums[i]) {
                        h--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[l], nums[h]));
                        l++;
                        h--;
                        while (l < h && nums[l] == nums[l - 1]) l++;
                        while (l < h && nums[h] == nums[h + 1]) h--;
                    }
                }
            }
            return res;
        }
    }
}
