public class Leet263 {
    class Solution {
        public boolean isUgly(int num) {
            if (num <= 0) {
                return false;
            }
            while (num % 2 == 0) {
                num = num / 2;
            }
            while (num % 3 == 0) {
                num = num / 3;
            }
            while (num % 5 == 0) {
                num = num / 5;
            }
            return num == 1;
        }
    }

    class Solution2 {
        public boolean isUgly(int num) {
            if (num <= 0) {
                return false;
            }
            for (int i = 2; i < 6; i++) {
                while (num % i == 0) {
                    num /= i;
                }
            }
            return num == 1;
        }
    }
}
