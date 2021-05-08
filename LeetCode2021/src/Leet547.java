import java.util.LinkedList;
import java.util.Queue;

/**
 * 2021-05-06 Thu
 */
public class Leet547 {
    // Approach 1: DFS
    // Time complexity : O(n^2) The complete matrix of size n^2 is traversed.
    // Space complexity : O(n). visited array of size nn is used.
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                // Mark as visited before dfs
                visited[i] = 1;
                dfs(isConnected, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, int[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                // Mark as visited before dfs
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }

    // Approach 2: BFS
    // Time complexity : O(n^2) The complete matrix of size n^2 is traversed.
    // Space complexity : O(n). visited array of size nn is used.
    public int findCircleNum2(int[][] isConnected) {
        int len = isConnected.length;
        int[] visited = new int[len];
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (visited[i] == 0) {
                // Mark as visited before adding to the queue
                visited[i] = 1;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int cur = queue.remove();
                    for (int j = 0; j < len; j++) {
                        if (isConnected[cur][j] == 1 && visited[j] == 0) {
                            // Mark as visited before adding to the queue
                            visited[j] = 1;
                            queue.add(j);
                        }
                    }
                }
                res++;
            }
        }
        return res;
    }

    // Approach 3: Union find
    // Time: O(n + m*α(n)) ≈ O(n + m) = O(n^2)
    // where m is the number of connections (union operations n*(n-1)/2), n is the number of nodes.
    // Space: O(n) parent and rank array
    public int findCircleNum3(int[][] isConnected) {
        int len = isConnected.length;
        int[] parent = new int[len];
        int[] rank = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
        int res = len;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    int p1 = find(i, parent);
                    int p2 = find(j, parent);
                    if (p1 != p2) {
                        if (rank[p1] < rank[p2]) {
                            parent[p1] = p2;
                        } else if (rank[p2] < p1) {
                            parent[p2] = p1;
                        } else {
                            parent[p1] = p2;
                            rank[p2]++;
                        }
                        res--;
                    }
                }
            }
        }
        return res;
    }

    private int find(int i, int[] parent) {
        if (parent[i] != i) {
            parent[i] = find(parent[i], parent);
        }
        return parent[i];
    }


}
