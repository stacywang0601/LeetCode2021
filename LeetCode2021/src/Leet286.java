import java.util.LinkedList;
import java.util.Queue;

public class Leet286 {
    // Multi-end BFS
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

    // DFS
    class Solution2 {
        int[] dir = {1, 0, -1, 0, 1};
        int[][] rooms;
        int m, n;
        public void wallsAndGates(int[][] rooms) {
            this.rooms = rooms;
            this.m = rooms.length;
            this.n = rooms[0].length;
            for(int i = 0; i< m; i++) {
                for(int j = 0; j < n; j++) {
                    if(rooms[i][j] == 0){
                        dfs(i, j);
                    }
                }
            }

        }
        private void dfs(int i, int j) {
            for(int k = 0; k < 4; k++) {
                int x = i + dir[k], y = j + dir[k+1];
                if(x < 0 || x >= m || y < 0 || y >=n || rooms[x][y] <= rooms[i][j] + 1) continue;
                rooms[x][y] = rooms[i][j] + 1;
                dfs(x, y);
            }

        }
    }
}
