public class Leet008 {
    class Solution {
        public int myAtoi(String s) {
            s = s.trim();
            int len = s.length();
            if (len == 0) return 0;

            int res = 0, sign = 1, i = 0;
            char[] arr = s.toCharArray();
            if (arr[i] == '+' || arr[i] == '-') {
                sign = arr[i] == '+' ? 1 : -1;
                i++;
            }

            int bound = Integer.MAX_VALUE / 10;

            while (i < len) {
                if (arr[i] < '0' || arr[i] > '9') break;

                int digit = arr[i] - '0';
                if (res > bound || (res == bound && digit > 7)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + digit;
                i++;
            }
            return sign * res;
        }
    }
}
