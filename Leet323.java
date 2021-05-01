// 2021-05-01 Sat
public class Leet323 {

    // Approach 1: Unin find without path compression
    // Time: O(m*n), where m is the number of edges, n is the number of nodes.
    // Space: O(n)
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);
            // points of same egde point to the same parent
            if(p1 != p2) {
                parent[p1] = p2;
                // connect 2 sub component, reduce n
                n--;
            }
        }
        return n;
    }

    // Without Path Compression - just keep finding the parent
    private int find(int[] parent, int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return parent[i];
    }

    /***********************************************************************************/

    // Approach 2: Unin find with path compression
    // Time: O(n+mlogn), where m is the number of edges, n is the number of nodes.
    // Space: O(n)
    public int countComponents2(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            int p1 = find2(parent, edge[0]);
            int p2 = find2(parent, edge[1]);
            // points of same egde point to the same parent
            if(p1 != p2) {
                parent[p1] = p2;
                // connect 2 sub component, reduce n
                n--;
            }
        }
        return n;
    }

    // find parent - update the parent to root parent when finding
    private int find2(int[] parent, int i) {
        if(parent[i] != i) {
            // path compression to find the ultimate parent
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    /***********************************************************************************/

    // Approach 3: Unin find with path compression & union by rank
    // Time: O(n + m*α(n)) ≈ O(n + m), where m is the number of connections (union operations), n is the number of nodes.
    // Space: O(n)
    public int countComponents3(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] e : edges) {
            int p1 = find3(parent, e[0]);
            int p2 = find3(parent, e[1]);
            // points of same egde point to the same parent
            if (p1 != p2) {
                if (rank[p1] < rank[p2]) {
                    parent[p1] = p2;
                } else if(rank[p1] > rank[p2]){
                    parent[p2] = p1;
                } else  {
                    //Increase rank when ranks are equal
                    rank[p1]++;
                    parent[p2] = p1;
                }
                n--;
            }
        }
        return n;
    }
    // find parent - update the parent to root parent when finding
    private int find3(int[] parent, int i) {
        if(parent[i] != i) {
            // path compression to find the ultimate parent
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}