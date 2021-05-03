import java.util.ArrayList;
import java.util.List;

public class Leet046 {
    // Approach 1: Ust cur.contains to check, more time complexity
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int num : nums) {
            if (cur.contains(num)) continue;
            cur.add(num);
            helper(nums, res, cur);
            cur.remove(cur.size() - 1);
        }
    }

    /********************************************************************************/

    // Approach 2: Ust visited[] to check, more space complexity
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper2(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void helper2(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            helper2(nums, res, cur, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
}
