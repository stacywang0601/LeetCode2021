import java.util.LinkedList;
import java.util.Queue;

public class Leet130 {
    class Solution {
        Queue<int[]> queue;
        char[][] board;
        int row, col;
        int[] dir = {1, 0, -1, 0, 1};

        public void solve(char[][] board) {
            queue = new LinkedList<>();
            this.board = board;
            this.row = board.length;
            this.col = board[0].length;

            for (int i = 0; i < row; i++) {
                bfs(i, 0);
                bfs(i, col - 1);
            }

            for (int j = 0; j < col; j++) {
                bfs(0, j);
                bfs(row - 1, j);
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void bfs(int r, int c) {
            if (board[r][c] == 'O') {
                queue.offer(new int[]{r, c});
                board[r][c] = '#';
            }
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                for (int k = 0; k < 4; k++) {
                    int x = i + dir[k], y = j + dir[k + 1];
                    if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != 'O') continue;
                    queue.offer(new int[]{x, y});
                    board[x][y] = '#';
                }
            }
        }
    }

    class Solution2 {
        char[][] board;
        int row, col;
        int[] dir = {1, 0, -1, 0, 1};

        public void solve(char[][] board) {
            this.board = board;
            this.row = board.length;
            this.col = board[0].length;

            for (int i = 0; i < row; i++) {
                dfs(i, 0);
                dfs(i, col - 1);
            }

            for (int j = 0; j < col; j++) {
                dfs(0, j);
                dfs(row - 1, j);
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        public void dfs(int r, int c) {
            if (board[r][c] != 'O') return;
            board[r][c] = '#';
            for (int k = 0; k < 4; k++) {
                int x = r + dir[k], y = c + dir[k + 1];
                if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != 'O') continue;
                dfs(x, y);
            }
        }
    }
}
