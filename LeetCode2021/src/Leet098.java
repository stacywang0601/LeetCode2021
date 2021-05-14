import java.util.Stack;

public class Leet098 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Recursive with range
    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            return validate(root, null, null);
        }

        private boolean validate(TreeNode root, Integer min, Integer max) {
            if (root == null) return true;
            if (min != null && root.val <= min) return false;
            if (max != null && root.val >= max) return false;
            return validate(root.left, min, root.val) && validate(root.right, root.val, max);
        }
    }

    // Recursive inorder with prev
    class Solution2 {
        // We use Integer instead of int as it supports a null value.
        private Integer prev;

        public boolean isValidBST(TreeNode root) {
            prev = null;
            return inorder(root);
        }

        private boolean inorder(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!inorder(root.left)) {
                return false;
            }
            if (prev != null && root.val <= prev) {
                return false;
            }
            prev = root.val;
            return inorder(root.right);
        }
    }

    // Iterative inorder
    class Solution3 {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root, pre = null;
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    if (pre != null && cur.val <= pre.val) return false;
                    pre = cur;
                    cur = cur.right;
                }
            }
            return true;
        }
    }
}
