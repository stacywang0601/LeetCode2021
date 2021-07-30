//2021-07-28 Wed
public class Leet037 {
    class Solution {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '0';
                        rows[i][num] = true;
                        cols[j][num] = true;
                        boxes[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
            dfs(board, 0, 0);
        }

        public boolean dfs(char[][] board, int i, int j) {
            if (i == 9 && j == 0) return true;
            if (board[i][j] != '.') return dfs(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1);

            int k = i / 3 * 3 + j / 3;

            for (int num = 1; num <= 9; num++) {
                if (!rows[i][num] && !cols[j][num] && !boxes[k][num]) {
                    board[i][j] = (char) (num + '0');
                    rows[i][num] = cols[j][num] = boxes[k][num] = true;
                    if (dfs(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1)) return true;
                    rows[i][num] = cols[j][num] = boxes[k][num] = false;
                    board[i][j] = '.';
                }
            }
            return false;
        }
    }
}
