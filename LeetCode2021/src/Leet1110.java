import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet1110 {
    // Delete cur node --> children node will be root
    // !deleted && isRoot --> add to res
    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> res = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int i : to_delete) set.add(i);
            dfs(root, true, set, res);
            return res;
        }

        private TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> set, List<TreeNode> res) {
            if (node == null) return null;
            boolean deleted = set.contains(node.val);
            if (!deleted && isRoot) res.add(node);
            node.left = dfs(node.left, deleted, set, res);
            node.right = dfs(node.right, deleted, set, res);
            return deleted ? null : node;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
