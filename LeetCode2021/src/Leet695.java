import java.util.LinkedList;
import java.util.Queue;

/*
 * 2021-05-07 Fri
 */
public class Leet695 {
    /*****************************************************************************************/
    // Approach 1: DFS check boundary first thing in dfs
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, areaOfIsland(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int areaOfIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + areaOfIsland(grid, i - 1, j)
                + areaOfIsland(grid, i + 1, j)
                + areaOfIsland(grid, i, j - 1)
                + areaOfIsland(grid, i, j + 1);
    }


    /*****************************************************************************************/
    // Approach 2: DFS mark visited and check boundary before dfs
    int[] dir = {0, 1, 0, -1, 0};

    public int maxAreaOfIsland2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        int res = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k], y = j + dir[k + 1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) continue;
            grid[x][y] = 0;
            res += dfs(grid, x, y);
        }
        return res;
    }

    /*****************************************************************************************************/
    // Approach3: BFS with direction[]
    int[] direction = {0, 1, 0, -1, 0};
    public int maxAreaOfIsland3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int temp = 1;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.remove();
                        for (int k = 0; k < 4; k++) {
                            int x = cur[0] + direction[k], y = cur[1] + direction[k + 1];
                            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) continue;
                            grid[x][y] = 0;
                            queue.add(new int[]{x, y});
                            temp++;
                        }
                    }
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }
}
