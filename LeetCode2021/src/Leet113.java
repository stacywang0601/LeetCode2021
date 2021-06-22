import java.util.ArrayList;
import java.util.List;

public class Leet113 {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            getPath(root, sum, res, new ArrayList<>());
            return res;
        }

        public void getPath(TreeNode root, int sum, List<List<Integer>> res, List<Integer> cur) {
            if (root == null) {
                return;
            }
            cur.add(root.val);
            if (root.left == null && root.right == null && root.val == sum) {
                res.add(new ArrayList<>(cur));
            }
            getPath(root.left, sum - root.val, res, cur);
            getPath(root.right, sum - root.val, res, cur);
            cur.remove(cur.size() - 1);
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
