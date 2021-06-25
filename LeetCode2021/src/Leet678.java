// 2021-06-24 Thu
public class Leet678 {
    // Greedy
    class Solution {
        public boolean checkValidString(String s) {
            int openMin = 0, openMax = 0;
            //openMin = left - right - stars
            //openMax = left - right + starts
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    openMax++;
                    openMin++;
                } else if (c == ')') {
                    openMax--;
                    openMin--;
                } else if (c == '*') {
                    openMax++;
                    openMin--;
                }
                if (openMax < 0) return false;
                if (openMin == -1) openMin = 0;   // -> left-right = stars - 1
                // Only when c == *, openMax != openMin, when openMax == -1, we return false
                // So when openMin == -1, means openMax >= 0, which means, stars >= 1
                // which means left-right >= 0
            }
            return openMin == 0;
        }
    }
}
