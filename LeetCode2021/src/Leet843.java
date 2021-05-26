import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet843 {
    class Solution {
        public void findSecretWord(String[] wordlist, Master master) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < 10; i++) {

                for (String s1 : wordlist) {
                    for (String s2 : wordlist) {
                        if (match(s1, s2) == 0) {
                            map.put(s1, map.getOrDefault(s1, 0) + 1);
                        }
                    }
                }

                String guess = "";
                int min = Integer.MAX_VALUE;
                for (String s : wordlist) {
                    if (map.getOrDefault(s, 0) < min) {
                        min = map.getOrDefault(s, 0);
                        guess = s;
                    }
                }

                int x = master.guess(guess);
                List<String> list2 = new ArrayList<>();
                for (String s : wordlist) {
                    if (match(guess, s) == x) {
                        list2.add(s);
                    }
                }
                wordlist = list2.toArray(new String[list2.size()]);
            }
        }

        private int match(String s1, String s2) {
            int len = s1.length(), res = 0;
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    res++;
                }
            }
            return res;
        }
    }
}
