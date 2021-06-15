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
        TreeNode pre;

        public boolean isValidBST(TreeNode root) {
            return inorder(root);
        }

        private boolean inorder(TreeNode node) {
            if (node == null) return true;
            if (!inorder(node.left)) return false;
            if (pre != null && pre.val >= node.val) return false;
            pre = node;
            return inorder(node.right);
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
