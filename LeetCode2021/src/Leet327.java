public class Leet327 {
    /**
     * S[i] = S(0, i), then S(i, j) = S[j] - S[i].
     * We then iterate through the left half with index left
     * For each left, we need to find two indices k and j in the right half where
     *
     * k is the first index satisfy sums[k] - sums[i] >= lower
     * j is the first index satisfy sums[j] - sums[i] > upper
     * Then the number of sums in [lower, upper] is j-k.
     * We also use another index right to copy the elements satisfy sum[right] < sum[left] to a cached helper array
     * in order to complete the merge sort.
     */
    public class Solution {
        int count = 0;
        int lower, upper;

        public int countRangeSum(int[] nums, int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
            int n = nums.length;
            long[] sum = new long[n + 1];
            long[] helper = new long[n + 1];
            sum[0] = 0;
            for (int i = 1; i < n + 1; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            mergeSort(sum, helper, 0, n);
            return count;
        }

        private void mergeSort(long[] sum, long[] helper, int low, int high) {
            if (low < high) {
                int mid = low + (high - low) / 2;
                mergeSort(sum, helper, low, mid);
                mergeSort(sum, helper, mid + 1, high);
                merge(sum, helper, low, mid, high);
            }
        }

        private void merge(long[] sum, long[] helper, int low, int mid, int high) {
            int right = mid + 1;
            int j = mid + 1, k = mid + 1;
            int cur = low;

            for (int left = low; left <= mid; left++) {
                while (k <= high && sum[k] - sum[left] < lower) {
                    k++;
                }
                while (j <= high && sum[j] - sum[left] <= upper) {
                    j++;
                }
                count += j - k;
                while (right <= high && sum[right] < sum[left]) {
                    helper[cur++] = sum[right++];
                }
                helper[cur++] = sum[left];
            }
            for (int i = low; i < right; i++) {
                sum[i] = helper[i];
            }
        }
    }
}
