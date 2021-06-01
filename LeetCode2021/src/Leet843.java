import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2021-06-01 Tue
 * */
public class Leet843 {
    static class Master {
        int guess(String word) {
            return 0;
        }
    }

    /*
     Generally, we will get 0 matches(which is the x above) from the master.guess. As a result, the size of wordlist reduces slowly.
     The probability of two words with 0 match is (25/26)^6 = 80%.
     That is to say, for a candidate word, we have 80% chance to see 0 match with the secret word.
     In this case, we had 80% chance to eliminate the candidate word and its "family" words which have at least 1 match.
     Additionally, in order to delete a max part of words, we select a candidate who has a big "family" (fewest 0 match with other words).
    We minimize our worst case, The worst case is max(the number of words with x matches), and we assume it equal to "the number of words with 0 matches"
    Time complexity O(N^2)
    Space complexity O(N)
     */
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
    /*
     In the previous solution, we compaired each two words. This make the complexity O(N^2) for each turn.
     But actually we don't have to do that. We just need to count the occurrence for each character on each position.
     If we can guess the word that not in the wordlist, we can guess the word based on the most frequent character on the position.
     Here we have to guess a word from the list, we still can calculate a score of similarity for each word, and
     guess the word with highest score.
     Time complexity O(N)
     Space complexity O(N)
     */
    class Solution2 {
        public void findSecretWord(String[] wordlist, Master master) {

            for (int t = 0; t < 10; t++) {

                int[][] count = new int[6][26];
                for (String s : wordlist) {
                    for (int i = 0; i < 6; i++) {
                        count[i][s.charAt(i) - 'a']++;
                    }
                }

                String guess = "";
                int max = Integer.MIN_VALUE;
                for (String s : wordlist) {
                    int sum = 0;
                    for (int i = 0; i < 6; i++) {
                        sum += count[i][s.charAt(i) - 'a'];
                    }
                    if (sum > max) {
                        max = sum;
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
