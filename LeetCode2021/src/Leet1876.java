public class Leet1876 {
    class Solution {
        public int countGoodSubstrings(String s) {
            int n = s.length();
            int res = 0;
            for (int i = 0; i < n - 2; i++) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(i + 1);
                char c3 = s.charAt(i + 2);
                if (c1 == c2 || c2 == c3 || c1 == c3) continue;
                res++;
            }
            return res;
        }
    }

    // Sliding window with 2 sides
    class Solution2 {
        public int countGoodSubstrings(String s) {
            int[] map = new int[26];

            int res = 0, len = s.length(), count = 0;

            if (len < 3) return res;

            int left = 0;

            for (int right = 0; right < len; right++) {
                int rr = s.charAt(right) - 'a';
                if (map[rr] == 0) {
                    count++;
                }
                map[rr]++;

                if (right - left == 3) {
                    int ll = s.charAt(left) - 'a';
                    if (map[ll] == 1) {
                        count--;
                    }
                    map[ll]--;
                    left++;
                }

                if (count == 3) {
                    res++;
                }

            }

            return res;

        }
    }
}
