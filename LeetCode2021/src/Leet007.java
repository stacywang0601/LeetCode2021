public class Leet007 {
    class Solution {
        public int reverse(int x) {
            int res = 0;

            while (x != 0) {
                int tail = x % 10;
                int newNum = res * 10 + tail;
                if ((newNum - tail) / 10 != res) return 0;
                res = newNum;
                x /= 10;
            }
            return res;
        }
    }
}
