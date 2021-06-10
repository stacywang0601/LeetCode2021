import java.util.Arrays;

public class Leet105 {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null) return null;

            int preLen = preorder.length, inLen = inorder.length;
            if (preLen == 0 && inLen == 0) return null;
            if (preLen == 1 && inLen == 1) return new TreeNode(preorder[0]);

            int index = 0;
            for (int i = 0; i < inLen; i++) {
                if (inorder[i] == preorder[0]) {
                    index = i;
                    break;
                }
            }
            TreeNode node = new TreeNode(inorder[index]);

            node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
            node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preLen), Arrays.copyOfRange(inorder, index + 1, inLen));

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
