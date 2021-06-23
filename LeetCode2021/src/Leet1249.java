import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leet1249 {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            Stack<Integer> stack = new Stack<>();
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(i);
                } else if (c == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        // invalid close
                        set.add(i);
                    }
                }
            }

            // invalid open
            while (!stack.isEmpty()) {
                set.add(stack.pop());
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (!set.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }

    class Solution2 {
        public String minRemoveToMakeValid(String s) {
            StringBuilder result = remove(s, '(', ')');
            String reverse = result.reverse().toString();
            result = remove(reverse, ')', '(');
            return result.reverse().toString(); // reverse back
        }
        private StringBuilder remove(String s, char open, char close) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == open) {
                    count++;
                } else if (c == close) {
                    if (count == 0) continue; // remove invalid close
                    count--;
                }
                sb.append(c);
            }
            return sb;
        }
    }

    class Solution3 {
        public String minRemoveToMakeValid(String s) {
            // Pass 1: Remove all invalid ")"
            StringBuilder sb = new StringBuilder();
            int open = 0, count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    open++;
                    count++;
                } else if (c == ')') {
                    if (count == 0) continue; // remove invalid close
                    count--;
                }
                sb.append(c);
            }
            // Pass 2: Remove the rightmost "("
            StringBuilder result = new StringBuilder();
            int close = open - count; // all open - (all open - valid close) = valid close = valid open
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == '(') {
                    close--;
                    if (close < 0) continue;
                }
                result.append(c);
            }

            return result.toString();
        }
    }
}
