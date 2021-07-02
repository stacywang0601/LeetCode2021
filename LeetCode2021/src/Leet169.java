public class Leet169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int res = 0, count = 0;

            for (int num : nums) {
                if (count == 0) {
                    res = num;
                }
                if (num == res) {
                    count++;
                } else {
                    count--;
                }
            }
            return res;
        }
    }
}