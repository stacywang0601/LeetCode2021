// 2021-05-01 Sat
public class Leet200 {

    // Approach 1: DFS
    // Time: O(m*n), where m is the number of rows and n is the number of columns.
    // Space: O(m*n)
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length
                || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    /***********************************************************************************/

    // Approach 2: Unin find with path compression
    // Time: O((m*n) + (m*n)logmn), where m is the number of rows and n is the number of columns.
    // Space: O(m*n)
    public int numIslands2(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, res=0;
        int[] dir = { 0, 1, 0, -1, 0 };
        int[] parent = new int[m * n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    parent[i*n+j] = i*n+j;
                    res++;
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    grid[i][j] = '#';
                    for (int k = 0; k < 4; k++){
                        int x = i + dir[k], y = j + dir[k+1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') continue;
                        int p1 = find2(i*n+j, parent), p2 = find2(x*n+y, parent);
                        if (p1 != p2){
                            parent[p1] = p2;
                            res--;
                        }
                    }
                }
            }
        }

        return res;
    }
    private int find2( int i, int[] parent){
        if(parent[i] != i) {
            parent[i] = find(parent[i], parent);
        }
        return parent[i];
    }

    /***********************************************************************************/

    // Approach 3: Unin find with path compression & union by rank
    // Time: O(m*n + m*n*α(m*n)) ≈ O(m*n), where m is the number of rows and n is the number of columns.
    // Space: O(m*n)
    public int numIslands3(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, res=0;
        int[] dir = { 0, 1, 0, -1, 0 };
        int[] parent = new int[m*n];
        int[] rank = new int[m*n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    parent[i*n+j] = i*n+j;
                    res++;
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    grid[i][j] = '#';
                    for (int k = 0; k < 4; k++){
                        int x = i + dir[k], y = j + dir[k+1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') continue;
                        int p1 = find3(i*n+j, parent), p2 = find3(x*n+y, parent);
                        if (p1 != p2){
                            if(rank[p1] < rank[p2]) {
                                parent[p1] = p2;
                            }else if(rank[p2] < p1) {
                                parent[p2] = p1;
                            }else {
                                parent[p1] = p2;
                                rank[p2]++;
                            }
                            res--;
                        }
                    }
                }
            }
        }

        return res;
    }
    public int find3( int i, int[] parent){
        if(parent[i] != i) {
            parent[i] = find(parent[i], parent);
        }
        return parent[i];
    }
}