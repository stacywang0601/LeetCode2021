import java.util.ArrayList;
import java.util.List;
/*
 * 2021-05-03 Mon
 * Sliding window with int[26] to count
 */
public class Leet438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int len1 = s.length(), len2 = p.length();
        if (len2 > len1) return res;

        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
        }

        int count = 0, left = 0;
        for (int right = 0; right < len1; right++) {
            int rr = s.charAt(right) - 'a';
            if (map[rr] > 0) {
                count++;
            }
            map[rr]--;

            if (right - left == len2) {
                int ll = s.charAt(left) - 'a';
                if (map[ll] >= 0) {
                    count--;
                }
                map[ll]++;
                left++;
            }

            if (count == len2) {
                res.add(left);
            }
        }
        return res;
    }
}
