import java.util.LinkedList;
import java.util.Queue;

/*
The performances of MultiEnd is very stable and have time complexities of O(m*n) for a m x n square matrix.

 The time complexity for NaiveBFS should be O(m^2*n^2) in the worst case. However is not shown in our tests.

 The performance of recursive DFS is very unstable. It is much slower than BFS if the rooms are interconnected.
 It is only faster than BFS when small groups of rooms are isolated.
 In the worst case the time complexity is also O(m^2*n^2).

 Thus, for this problem we should prefer BFS over DFS. And the best Solution is Multi End BFS.
 */
public class Leet286 {
    // Multi-end BFS O(m*n)
    class Solution {
        int[] dir = {0, 1, 0, -1, 0};

        public void wallsAndGates(int[][] rooms) {
            int m = rooms.length, n = rooms[0].length;
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.remove();
                int i = cur[0], j = cur[1];
                for (int k = 0; k < 4; k++) {
                    int x = i + dir[k];
                    int y = j + dir[k + 1];
                    if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] != Integer.MAX_VALUE) continue;
                    rooms[x][y] = rooms[i][j] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }

    // DFS O(m^2*n^2)
    class Solution2 {
        int[] dir = {1, 0, -1, 0, 1};
        int[][] rooms;
        int m, n;

        public void wallsAndGates(int[][] rooms) {
            this.rooms = rooms;
            this.m = rooms.length;
            this.n = rooms[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) {
                        dfs(i, j);
                    }
                }
            }

        }

        private void dfs(int i, int j) {
            for (int k = 0; k < 4; k++) {
                int x = i + dir[k], y = j + dir[k + 1];
                if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] <= rooms[i][j] + 1) continue;
                rooms[x][y] = rooms[i][j] + 1;
                dfs(x, y);
            }
        }
    }

    // Naive BFS O(m^2*n^2)
    class Solution3 {
        int[] dir = {1, 0, -1, 0, 1};
        int[][] rooms;
        int m, n;
        Queue<int[]> queue;

        public void wallsAndGates(int[][] rooms) {
            this.rooms = rooms;
            this.m = rooms.length;
            this.n = rooms[0].length;
            this.queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) {
                        queue.add(new int[]{i, j});
                        bfs(i, j);
                    }
                }
            }

        }

        private void bfs(int i, int j) {

            for (int k = 0; k < 4; k++) {
                int x = i + dir[k], y = j + dir[k + 1];
                if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] <= rooms[i][j] + 1) continue;
                rooms[x][y] = rooms[i][j] + 1;
                queue.add(new int[]{x, y});
                bfs(x, y);
            }

        }
    }
}
