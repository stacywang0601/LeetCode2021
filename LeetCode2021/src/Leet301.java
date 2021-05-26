import java.util.ArrayList;
import java.util.List;
/**
 * The counter will increase when it is ‘(‘ and decrease when it is ‘)’.
 * Whenever the counter is negative, we have more ‘)’ than ‘(‘ in the prefix.
 * To avoid duplicates, only remove the first ')' in a series of consecutive ')'s.
 * After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string.
 * However, we need to keep another information: the last removal position.
 * If we do not have this position, we will generate duplicate by removing two ‘)’ in two steps only with a different order.
 * For this, we keep tracking the last removal position and only remove ‘)’ after that.
 * Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘?
 * The answer is: do the same from right to left.
 * However a cleverer idea is: reverse the string and reuse the code!
 * */
public class Leet301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        // no need empty string check since Input: "" Expected: [""], not empty list
        if (s == null) return res;
        helper(s, res, 0, 0, '(', ')');
        return res;
    }

    private void helper(String s, List<String> res, int start, int lastJ, char open, char close) {
        int count = 0;

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == open) {
                count++;
            } else if (s.charAt(i) == close) {
                count--;
            }

            if (count < 0) {
                for (int j = lastJ; j <= i; j++) {
                    // s.charAt(j) == close && s.charAt(j - 1) != close make sure we only remove the fist close
                    // But when j = lastJ = 0, i-1 is -1, so need boundary check
                    if (s.charAt(j) == close && (j == 0 || s.charAt(j - 1) != close)) {
                        helper(s.substring(0, j) + s.substring(j + 1), res, i, j, open, close);
                    }
                }
                // return after removing this first open. leave later to the recursive calls
                return;
            }
        }

        //Outside for loop, which means start ==  s.length()!!!
        // So no need to have if(start == s.length()) return at the beginning!!!
        String reverse = new StringBuilder(s).reverse().toString();
        if (open == '(') {
            helper(reverse, res, 0, 0, ')', '(');
        } else {
            res.add(reverse);
        }
    }
}
