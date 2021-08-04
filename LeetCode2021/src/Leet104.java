import java.util.LinkedList;
import java.util.Queue;

public class Leet104 {
    // Recursive Time: O(n), Space: average O(logn), worst O(n)
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        }
    }

    // Iterative Time: O(n), Space: O(n)
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 0, size = 0;
            TreeNode cur;
            queue.add(root);

            while (!queue.isEmpty()) {
                depth++;
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    cur = queue.remove();
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                }
            }
            return depth;
        }
    }
}
