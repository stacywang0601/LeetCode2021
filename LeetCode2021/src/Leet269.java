import java.util.*;

/**
 * 2021-06-01 Tue
 */
public class Leet269 {
    class Solution {
        public String alienOrder(String[] words) {
            List<Integer>[] adj = new ArrayList[26];
            int[] degree = new int[26];

            // Step1: Initialize
            for (int i = 0; i < 26; i++) {
                adj[i] = new ArrayList<>();
                degree[i] = -1;
            }

            // Step2: Build the graph
            for (int i = 0; i < words.length; i++) {
                for (char c : words[i].toCharArray()) {
                    if (degree[c - 'a'] < 0) {
                        degree[c - 'a'] = 0;
                    }
                }

                if (i > 0) {
                    String w1 = words[i - 1], w2 = words[i];
                    int len = Math.min(w1.length(), w2.length());
                    for (int j = 0; j < len; j++) {
                        int c1 = w1.charAt(j) - 'a', c2 = w2.charAt(j) - 'a';
                        // Only add when c1 != c2
                        if (c1 != c2) {
                            if (!adj[c1].contains(c2)) {
                                adj[c1].add(c2);
                                degree[c2]++;
                            }
                            // Only check first set character, then break
                            break;
                        }
                        // len - 1
                        if (j == w2.length() - 1 && w1.length() > w2.length()) return "";
                    }
                }
            }

            // Step3: Topological Sort
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < 26; i++) {
                if (degree[i] == 0) {
                    queue.add(i);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                int cur = queue.remove();
                sb.append((char) (cur + 'a'));
                for (int nei : adj[cur]) {
                    degree[nei]--;
                    if (degree[nei] == 0) {
                        queue.add(nei);
                    }
                }
            }

            // Step 4: Check cyclic
            for (int i : degree) {
                // have to be > 0, since initialize as -1
                if (i > 0) {
                    return "";
                }
            }

            return sb.toString();
        }
    }
}
