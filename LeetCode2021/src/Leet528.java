public class Leet528 {
    class Solution {
        private int[] prefixSums;
        private int totalSum;

        public Solution(int[] w) {
            this.prefixSums = new int[w.length];

            int prefixSum = 0;
            for (int i = 0; i < w.length; ++i) {
                prefixSum += w[i];
                this.prefixSums[i] = prefixSum;
            }
            this.totalSum = prefixSum;
        }

        public int pickIndex() {
            double target = totalSum * Math.random();
            int l = 0, h = prefixSums.length;
            // find the first element greaterOrEqual than target
            while (l < h) {
                int m = l + (h - l) / 2;
                if (prefixSums[m] >= target) {
                    h = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
