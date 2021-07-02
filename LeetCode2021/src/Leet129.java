public class Leet129 {

    // Solution1-- global variable  +  void dfs --> from top to bottom
    class Solution {
        int sum = 0;

        public int sumNumbers(TreeNode root) {
            getSum(root, 0);
            return sum;
        }

        private void getSum(TreeNode node, int cur) {
            if (node == null) return;
            cur = cur * 10 + node.val;
            if (node.left == null && node.right == null) sum += cur;
            getSum(node.left, cur);
            getSum(node.right, cur);
        }
    }

    // Solution2 -- int dfs + return every part --> from bottom to top
    class Solution2 {
        public int sumNumbers(TreeNode root) {
            return getSum(root, 0);
        }

        private int getSum(TreeNode node, int cur) {
            if (node == null) return 0;

            cur = cur * 10 + node.val;
            if (node.left == null && node.right == null) {
                return cur;
            }

            return getSum(node.left, cur) + getSum(node.right, cur);
        }
    }
}
