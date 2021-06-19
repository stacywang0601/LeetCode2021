import java.util.*;

/**
 * 2021-06-18 Fri
 */
public class Leet107 {
    // BFS
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int len = queue.size();
                List<Integer> curLayer = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.remove();
                    curLayer.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                res.add(0, curLayer);
            }
            return res;
        }
    }

    // DFS with level number
    class Solution2 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(root, res, 0);
            Collections.reverse(res);
            return res;
        }

        private void dfs(TreeNode node, List<List<Integer>> res, int level) {
            if (node == null) return;

            if (res.size() < level + 1) {
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(node.val);
            dfs(node.left, res, level + 1);
            dfs(node.right, res, level + 1);
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
