public class Leet065 {
    class Solution {
        public boolean isNumber(String s) {
            boolean seenDigit = false;
            boolean seenExponent = false;
            boolean seenDot = false;

            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (Character.isDigit(cur)) {
                    seenDigit = true;
                } else if (cur == '+' || cur == '-') {
                    if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                        return false;
                    }
                } else if (cur == 'e' || cur == 'E') {
                    if (seenExponent || !seenDigit) {
                        return false;
                    }
                    seenExponent = true;
                    seenDigit = false;
                } else if (cur == '.') {
                    if (seenDot || seenExponent) {
                        return false;
                    }
                    seenDot = true;
                } else {
                    return false;
                }
            }

            return seenDigit;
        }
    }
}
