import java.util.ArrayList;
import java.util.List;

public class Leet022 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) return res;
            helper(res, new StringBuilder(), 0, 0, n);
            return res;
        }

        private void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
            if (open == n && close == n) {
                res.add(sb.toString());
                return;
            }
            if (open < n) {
                sb.append("(");
                helper(res, sb, open + 1, close, n);
                sb.setLength(sb.length() - 1);
            }

            if (close < open) {
                sb.append(")");
                helper(res, sb, open, close + 1, n);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
