import java.util.Arrays;

public class Leet106 {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int lenI = inorder.length;
            int lenP = postorder.length;

            if (lenI == 0 && lenP == 0) return null;

            int index = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == postorder[lenP - 1]) {
                    index = i;
                    break;
                }
            }

            TreeNode root = new TreeNode(inorder[index]);

            int[] inorder1 = Arrays.copyOfRange(inorder, 0, index);
            int[] inorder2 = Arrays.copyOfRange(inorder, index + 1, lenI);

            int[] postorder1 = Arrays.copyOfRange(postorder, 0, index);
            int[] postorder2 = Arrays.copyOfRange(postorder, index, lenP - 1);

            root.left = buildTree(inorder1, postorder1);
            root.right = buildTree(inorder2, postorder2);
            return root;
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
