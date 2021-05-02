// 2021-05-01 Sat
public class Leet209 {
    /* sliding window: O(n)
     * Since the given array contains only positive integers, the subarray sum can only increase
     * by including more elements. Therefore, you don't have to include more elements once the
     * current subarray already has a sum large enough. This gives the linear time complexity
     * solution by maintaining a minimum window with a two indices.
     */
    // Time: O(n), where n is the length of the array
    // Space: O(1)

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, res = Integer.MAX_VALUE, sum  = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= target) {
                res = Math.min(res, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
