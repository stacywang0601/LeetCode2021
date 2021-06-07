public class Leet1477 {
    class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            int len = arr.length;
            int[] currMinLen = new int[len];
            int cur = len + 1, res = len + 1;
            int start = 0, sum = 0;

            for (int i = 0; i < len; i++) {
                sum += arr[i];
                while (sum > target) {
                    sum -= arr[start++];
                }
                if (sum == target) {
                    cur = Math.min(cur, i - start + 1);
                    if (start > 0) {
                        res = Math.min(res, currMinLen[start - 1] + i - start + 1);
                    }
                }
                currMinLen[i] = cur;
            }
            return res == len + 1 ? -1 : res;
        }
    }
}
