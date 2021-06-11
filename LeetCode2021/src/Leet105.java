import java.util.Arrays;

public class Leet105 {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int len = preorder.length;
            if (len == 0) return null;
            int index = 0;
            for (int i = 0; i < len; i++) {
                if (inorder[i] == preorder[0]) {
                    index = i;
                    break;
                }
            }

            TreeNode node = new TreeNode(preorder[0]);
            node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
            node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, len), Arrays.copyOfRange(inorder, index + 1, len));
            return node;
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
