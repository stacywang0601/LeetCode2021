import java.util.*;

public class Leet126 {
    public class Solution {
        Map<String, List<String>> map = new HashMap<>();
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            Set<String> dict = new HashSet<>(wordList);
            if (!dict.contains(endWord)) return res;

            Set<String> start = new HashSet<>();
            Set<String> end = new HashSet<>();
            start.add(beginWord);
            end.add(endWord);
            buildMap(start, end, dict, false);

            List<String> cur = new ArrayList<>();
            cur.add(beginWord);
            helper(beginWord, endWord, res, cur);
            return res;
        }

        // Bidirectional Breadth-First Search (BFS)
        private void buildMap(Set<String> start, Set<String> end, Set<String> dict, boolean reverse) {
            if (start.size() == 0) return;
            if (start.size() > end.size()) {
                buildMap(end, start, dict, !reverse);
                return;
            }

            dict.removeAll(start);
            boolean finished = false;
            Set<String> next = new HashSet<>();

            for (String word : start) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        arr[i] = c;
                        String nextWord = new String(arr);
                        if (dict.contains(nextWord)) {
                            if (end.contains(nextWord)) {
                                finished = true;
                            } else {
                                next.add(nextWord);
                            }
                            String first = reverse ? nextWord : word;
                            String second = reverse ? word : nextWord;
                            List<String> neighbor = map.getOrDefault(first, new ArrayList<String>());
                            neighbor.add(second);
                            map.put(first, neighbor);
                        }
                    }
                    arr[i] = old;
                }
            }
            if (!finished) {
                buildMap(next, end, dict, reverse);
            }
        }

        // Backtracking
        private void helper(String beginWord, String endWord, List<List<String>> res, List<String> cur) {
            if (beginWord.equals(endWord)) {
                res.add(new ArrayList<>(cur));
                return;
            }
            if (!map.containsKey(beginWord)) return;

            for (String s : map.get(beginWord)) {
                cur.add(s);
                helper(s, endWord, res, cur);
                cur.remove(cur.size() - 1);
            }
        }


    }
}
