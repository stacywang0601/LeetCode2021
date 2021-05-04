import java.util.*;

/*
 * 2021-05-03 Mon
 * Postorder traversal + serialization
 */
public class Leet652 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, new HashMap<>(), res);
        return res;
    }

    private String dfs(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String left = dfs(cur.left, map, res);
        String right = dfs(cur.right, map, res);
        StringBuilder sb = new StringBuilder();
        sb.append(cur.val).append(",").append(left).append(",").append(right);
        String s = sb.toString();
        if (map.getOrDefault(s, 0) == 1) {
            res.add(cur);
        }
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}
