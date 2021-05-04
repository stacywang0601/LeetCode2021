/*
 * 2021-05-03 Mon
 * Sliding window with int[26] to count
 */
public class Leet567 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        int[] map = new int[26];
        for (char c : s1.toCharArray()) {
            map[c - 'a']++;
        }
        int left = 0, count = 0;
        for (int right = 0; right < len2; right++) {
            int rr = s2.charAt(right) - 'a';
            if (map[rr] > 0) {
                count++;
            }
            map[rr]--;
            if (right - left == len1) {
                int ll = s2.charAt(left) - 'a';
                if (map[ll] >= 0) {
                    count--;
                }
                map[ll]++;
                left++;
            }
            if (count == len1) {
                return true;
            }
        }
        return false;
    }
}
