public class Leet114 {
    public class Solution1 {
        private TreeNode pre = null;
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            //right first!
            flatten(root.right);
            flatten(root.left);
            root.right = pre;
            root.left = null;
            pre = root;
        }
    }

    /* Method2--iteratively
     * find the rightmost in left subtree
     */
    public class Solution2 {
        public void flatten(TreeNode root) {
            if (root == null) return;

            while (root != null) {
                //left not null
                if (root.left != null) {
                    TreeNode rightmost = root.left;
                    while (rightmost.right != null) {
                        rightmost = rightmost.right;
                    }
                    // put root.left and rightmost between root and root.right
                    rightmost.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
                root = root.right;
            }
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
