/*
* 2021-06-04 Fri
* */
public class Leet198 {
    /*
     * dp[i][0] don't rub current
     * dp[i][i] rub current
     * */
    class Solution {
        public int rob(int[] num) {
            int[][] dp = new int[num.length + 1][2];
            for (int i = 1; i < num.length + 1; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + num[i - 1];
            }
            return Math.max(dp[num.length][0], dp[num.length][1]);
        }
    }

    /*
     * prevNo don't rub current
     * prevYes rub current
     * */
    class Solution2 {
        public int rob(int[] num) {
            int preNo = 0, preYes = 0;
            for (int n : num) {
                int temp = preNo;
                preNo = Math.max(preNo, preYes);
                preYes = temp + n;
            }
            return Math.max(preNo, preYes);
        }
    }
}
