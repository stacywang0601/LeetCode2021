import java.util.*;

/**
 * 2021-06-01 Tue
 * */
public class Leet269 {
    class Solution {
        public String alienOrder(String[] words) {
            // Step1: Initialize
            List<Integer>[] adj = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            int[] degree = new int[26];
            Arrays.fill(degree, -1);

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
                        if (c1 != c2) {
                            if (!adj[c1].contains(c2)) {
                                adj[c1].add(c2);
                                degree[c2]++;
                            }
                            break;
                        }
                        // "abcd" -> "ab"
                        if (j == w2.length() - 1 && w1.length() > w2.length()) {
                            return "";
                        }
                    }
                }
            }

            // Step3: Topological Sort
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < degree.length; i++) {
                if (degree[i] == 0) {
                    q.add(i);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                int i = q.poll();
                sb.append((char) ('a' + i));
                for (int j : adj[i]) {
                    degree[j]--;
                    if (degree[j] == 0) {
                        q.add(j);
                    }
                }
            }
            
            // Step 4: Check cyclic
            for (int d : degree) {
                if (d > 0) {
                    return "";
                }
            }

            return sb.toString();
        }
    }
}
