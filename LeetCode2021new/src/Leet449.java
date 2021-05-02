import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2021-05-01 Sat
public class Leet449 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // DFS
    // Time: O(n), where n is the number of nodes since we visit each node once
    // Space: O(n) since we keep the entire tree

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Empty check
        if (data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(Queue<String> queue, int lower, int upper) {
        // Empty check
        if (queue.isEmpty()) return null;
        String cur = queue.peek();
        int val = Integer.parseInt(cur);
        // Boundary check
        if (val < lower || val > upper) return null;
        queue.remove();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(queue, lower, val);
        root.right = deserialize(queue, val, upper);
        return root;
    }
}