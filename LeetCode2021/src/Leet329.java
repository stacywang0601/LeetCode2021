public class Leet329 {
    class Solution {
        int[][] matrix;
        int m, n;
        int[] dir = {1, 0, -1, 0, 1};

        public int longestIncreasingPath(int[][] matrix) {
            this.matrix = matrix;
            this.m = matrix.length;
            this.n = matrix[0].length;
            int[][] memo = new int[m][n];

            int res = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, dfs(i, j, memo));
                }
            }
            return res;
        }

        private int dfs(int i, int j, int[][] memo) {
            if (memo[i][j] != 0) return memo[i][j];

            int res = 1;
            for (int k = 0; k < 4; k++) {
                int x = i + dir[k], y = j + dir[k + 1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
                res = Math.max(res, 1 + dfs(x, y, memo));
            }
            memo[i][j] = res;
            return res;
        }
    }
}
