public class Leet124 {
    class Solution {
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            getSum(root);
            return max;
        }

        private int getSum(TreeNode node) {
            if (node == null) return 0;
            int left = Math.max(getSum(node.left), 0);
            int right = Math.max(getSum(node.right), 0);
            max = Math.max(max, left + right + node.val);
            return Math.max(left, right) + node.val;
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
