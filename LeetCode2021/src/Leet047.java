import java.util.*;

/*
 * 2021-05-03 Sun
 * Sort
 * i > 0 && nums[i] == nums[i - 1] && visited[i - 1] to dedup
 */
public class Leet047 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            helper(nums, res, cur, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }

}
