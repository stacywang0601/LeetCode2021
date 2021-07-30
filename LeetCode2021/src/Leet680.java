public class Leet680 {
    class Solution {
        public boolean validPalindrome(String s) {
            int l = 0, h = s.length() - 1;
            while (l < h) {
                if (s.charAt(l) != s.charAt(h)) {
                    return isPal(s.substring(0, l) + s.substring(l + 1, s.length()))
                            || isPal(s.substring(0, h) + s.substring(h + 1, s.length()));
                }
                l++;
                h--;
            }
            return true;
        }

        private boolean isPal(String s) {
            int l = 0, h = s.length() - 1;
            while (l < h) {
                if (s.charAt(l) != s.charAt(h)) return false;
                l++;
                h--;
            }
            return true;
        }
    }
}
