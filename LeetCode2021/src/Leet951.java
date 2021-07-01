import java.util.LinkedList;
import java.util.Queue;

public class Leet951 {
    // Recursion works for both unique and equal case
    // Unique case is O(2^H) = O(n)
    // Equal case is O(4^H) = O(2^logn^2) = O(n^2)
    class Solution {
        public boolean flipEquiv(TreeNode r1, TreeNode r2) {
            if (r1 == null && r2 == null) return true;
            if (r1 == null || r2 == null) return false;
            if (r1.val == r2.val) {
                return flipEquiv(r1.left, r2.left) && flipEquiv(r1.right, r2.right) ||
                        flipEquiv(r1.left, r2.right) && flipEquiv(r1.right, r2.left);
            }
            return false;
        }
    }

    // Iteration only works unique case with O(n)
    class Solution2 {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root1);
            queue.offer(root2);

            while (!queue.isEmpty()) {
                TreeNode curr1 = queue.poll();
                TreeNode curr2 = queue.poll();

                if (curr1 == null && curr2 == null) {
                    continue;
                }
                if (!isEquals(curr1, curr2)) {
                    return false;
                }
                if (isEquals(curr1.left, curr2.left) && isEquals(curr1.right, curr2.right)) {
                    queue.offer(curr1.left);
                    queue.offer(curr2.left);
                    queue.offer(curr1.right);
                    queue.offer(curr2.right);
                } else if (isEquals(curr1.left, curr2.right) && isEquals(curr1.right, curr2.left)) {
                    queue.offer(curr1.left);
                    queue.offer(curr2.right);
                    queue.offer(curr1.right);
                    queue.offer(curr2.left);
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isEquals(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return true;
            if (root1 == null || root2 == null) return false;
            return root1.val == root2.val;
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
