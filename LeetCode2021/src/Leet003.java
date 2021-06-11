import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leet003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int start = 0, res = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    start = Math.max(start, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                res = Math.max(res, i - start + 1);
            }
            return res;
        }
    }

    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int start = 0, res = 0;
            int[] map = new int[256];
            Arrays.fill(map, -1);
            for (int i = 0; i < s.length(); i++) {
                if (map[s.charAt(i)] != -1) {
                    start = Math.max(start, map[s.charAt(i)] + 1);
                }
                map[s.charAt(i)] = i;
                res = Math.max(res, i - start + 1);
            }
            return res;
        }
    }
}
