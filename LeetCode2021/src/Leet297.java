import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2021-05-01 Sat
public class Leet297 {
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

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(new LinkedList(Arrays.asList(data.split(","))));
    }

    private TreeNode deserialize(Queue<String> queue) {
        String cur = queue.remove();
        if (cur.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}
