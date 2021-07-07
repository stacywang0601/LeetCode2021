public class Leet551 {
    class Solution {
        public boolean checkRecord(String s) {
            int Lcount = 0, Acount = 0;
            for (char c : s.toCharArray()) {
                if (c == 'A') {
                    Acount++;
                    if (Acount == 2) return false;
                    Lcount = 0;
                } else if (c == 'L') {
                    Lcount++;
                    if (Lcount == 3) return false;
                } else {
                    Lcount = 0;
                }
            }
            return true;
        }
    }
}
