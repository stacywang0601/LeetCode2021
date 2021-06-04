import java.util.Stack;

public class Leet032 {
    // Solution 1: Stack push '(' and unmatched ')'

    /**
     * only update the res when we find a "pair"
     * since we pop every time we find a valid parentheses
     * if stack is not empty after pop, it means the peek() is last invalid position
     */
    class Solution1 {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i + 1);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                } else {
                    // push '(' and unmatched ')'
                    stack.push(i);
                }
            }
            return res;
        }
    }

    // Solution 1.1 Stack with -1: combine 2 situations as 1 after popping
    class Solution11 {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int res = 0;
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    res = Math.max(res, i - stack.peek());
                } else {
                    // push '(' and unmatched ')'
                    stack.push(i);
                }
            }
            return res;
        }
    }

    //Solution 2 dp
    /*
     * Dynamic programming :
     * dp[i]: longest length of valid parentheses which is end at i.
     *
     * 1. s[i] = '(', dp[i] = 0,since any string end with '(' cannot be a valid one.
     *
     * 2. s[i] = ')'
     *
     * (2.a). s[i-1] = '(', dp[i] = dp[i-2] + 2
     *
     * (2.b). s[i-1] = ')' and s[i-dp[i-1]-1] == '(',
     * dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
     *
     * since when s[i-1] = '(', dp[i-1] = 0
     * dp[i-1] + 2 + dp[i-dp[i-1]-2] = dp[i-2] + 2
     * so (2.a) is included in (2.b) 但最好不要，分开逻辑更清晰
     */

    class Solution2 {
        public int longestValidParentheses(String s) {
            int max = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        // Boundary check
                        if (i >= 2) {
                            dp[i] = dp[i - 2] + 2;
                        } else {
                            dp[i] = 2;
                        }
                    } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        // Boundary check
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            return max;
        }
    }

    //Add prefix ), doesn't need to check bound
    class Solution22 {
        public int longestValidParentheses(String s) {
            s = ")" + s;
            int res = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = dp[i - 2] + 2;
                    } else if (s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    }
                    res = Math.max(res, dp[i]);
                }
            }
            return res;
        }
    }
}
