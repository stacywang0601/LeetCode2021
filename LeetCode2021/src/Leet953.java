public class Leet953 {
    class Solution {
        int[] map = new int[26];

        public boolean isAlienSorted(String[] words, String order) {
            if (words == null) return true;

            for (int i = 0; i < order.length(); i++) {
                map[order.charAt(i) - 'a'] = i;
            }

            for (int i = 0; i < words.length - 1; i++) {
                if (bigger(words[i], words[i + 1])) {
                    return false;
                }
            }
            return true;
        }

        private boolean bigger(String a, String b) {
            int len1 = a.length(), len2 = b.length();
            int i = 0;

            while (i < len1 && i < len2) {
                char c1 = a.charAt(i);
                char c2 = b.charAt(i);
                if (c1 != c2) {
                    return map[c1 - 'a'] > map[c2 - 'a'];
                }
                i++;
            }
            return len1 > len2;
        }
    }
}
