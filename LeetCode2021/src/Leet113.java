import java.util.ArrayList;
import java.util.List;

public class Leet113 {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(root, targetSum, res, new ArrayList<>());
            return res;
        }

        private void dfs(TreeNode node, int sum, List<List<Integer>> res, List<Integer> cur) {
            if(node == null) return;
            cur.add(node.val);
            if(node.left == null && node.right == null && node.val == sum){
                res.add(new ArrayList<>(cur));
            }else {
                dfs(node.left, sum - node.val, res, cur);
                dfs(node.right, sum - node.val, res, cur);
            }
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
