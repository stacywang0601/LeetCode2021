import java.util.ArrayList;
import java.util.List;

public class Leet442 {
    /**
     * O(1) space
     * when find a number i, flip the number at position i-1 to negative.
     * if the number at position i-1 is already negative, i is the number that occurs twice.
     */

    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();

            for (int num : nums) {
                if (nums[Math.abs(num) - 1] < 0) {
                    res.add(Math.abs(num));
                }
                nums[Math.abs(num) - 1] *= -1;
            }
            // restore the num, not necessary if not needed
            for (int num : nums) {
                num = Math.abs(num);
            }
            return res;
        }
    }
}
