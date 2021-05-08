/*
 * 2021-05-07 Fri
 */
public class Leet695 {
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
}
