public class Leet1094 {
    // Bucket sort
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] location = new int[1001];
            for (int[] trip : trips) {
                location[trip[1]] += trip[0];
                location[trip[2]] -= trip[0];
            }
            int sum = 0;
            for (int num : location) {
                sum += num;
                if (sum > capacity) {
                    return false;
                }
            }
            return true;
        }
    }
}
