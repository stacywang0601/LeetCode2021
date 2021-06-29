import java.util.HashMap;
import java.util.Map;

public class Leet437 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int target;

        public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;
            this.target = sum;
            map.put(0, 1);
            return findPathSum(root, 0);
        }

        private int findPathSum(TreeNode cur, int sum) {
            if (cur == null) return 0;
            sum += cur.val;
            int numPathToCur = map.getOrDefault(sum - target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            int res = numPathToCur + findPathSum(cur.left, sum) + findPathSum(cur.right, sum);
            // restore the map, as the recursion goes from the bottom to the top
            map.put(sum, map.get(sum) - 1);
            return res;
        }
    }
}
