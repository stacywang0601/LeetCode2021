import java.util.ArrayList;
import java.util.List;

public class Leet131 {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            if (s == null || s.length() == 0) return res;
            helper(s, 0, new ArrayList<>(), res);
            return res;
        }

        private void helper(String s, int start, List<String> cur, List<List<String>> res) {
            if (start == s.length()) {
                res.add(new ArrayList<>(cur));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (isPalindrom(s.substring(start, i + 1))) {
                    cur.add(s.substring(start, i + 1));
                    helper(s, i + 1, cur, res);
                    cur.remove(cur.size() - 1);
                }
            }
        }

        private boolean isPalindrom(String s) {
            int l = 0, h = s.length() - 1;
            while (l < h) {
                if (s.charAt(l) != s.charAt(h)) {
                    return false;
                }
                l++;
                h--;
            }
            return true;
        }
    }
}
