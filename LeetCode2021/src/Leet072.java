public class Leet072 {
    public class Solution {
        /**
         * dp[0][0] : ""(empty string) to ""(empty string)
         *
         * dp[i+1][0]: word1[0...i] to ""(empty string)
         * dp[0][j+1]: ""(empty string) to word2[0...j]
         *
         * dp[i+1][j+1]:  word1[0...i]  to word2[0...j]
         * dp index is the length of word1 and word2
         *
         * Replace word1[i] by word2[j] (dp[i+1][j+1] = dp[i][j] + 1 (for replacement));
         * Delete word1[i] and word1[0..i - 1] = word2[0..j] (dp[i+1][j+1] = dp[i][j+1] + 1 (for deletion));
         * Insert word2[j] to word1[0..i] and word1[0..i] + word2[j] = word2[0..j] (dp[i+1][j+1] = dp[i+1][j] + 1 (for insertion)).
         **/
        public int minDistance(String word1, String word2) {

            int len1 = word1.length(), len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];

            for (int i = 0; i < len1; i++) {
                dp[i + 1][0] = i + 1;
            }
            for (int j = 0; j < len2; j++) {
                dp[0][j + 1] = j + 1;
            }

            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else {//replace, insert, remove
                        dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, Math.min(dp[i + 1][j] + 1, dp[i][j + 1] + 1));
                    }
                }
            }
            return dp[len1][len2];
        }
    }
}
