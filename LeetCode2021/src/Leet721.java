import java.util.*;

public class Leet721 {
    // DFS
    class Solution1 {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            // <email node, left and right neighbor email nodes>
            Map<String, Set<String>> graph = new HashMap<>();
            // <email, username> --> use to find all unique emails
            Map<String, String> emailToName = new HashMap<>();

            // Build email relationship graph;
            for (List<String> account : accounts) {
                String userName = account.get(0);
                for (int i = 1; i < account.size(); i++) {
                    if (!graph.containsKey(account.get(i))) {
                        graph.put(account.get(i), new HashSet<>());
                    }

                    if (i > 1) {
                        graph.get(account.get(i)).add(account.get(i - 1));
                        graph.get(account.get(i - 1)).add(account.get(i));
                    }

                    // Also udpate emailToName mapping
                    emailToName.put(account.get(i), userName);
                }
            }

            // Mark visited emails
            Set<String> visited = new HashSet<>();
            // Final merged res
            List<List<String>> merged = new LinkedList<>();

            // DFS: use email to search the graph;
            for (String cur : emailToName.keySet()) {
                // Merged res for each email/name
                List<String> res = new LinkedList<>();
                if (visited.add(cur)) {
                    dfs(graph, cur, visited, res);
                    // In sorted orders
                    Collections.sort(res);
                    // Add name as the first element
                    res.add(0, emailToName.get(cur));
                    merged.add(res);
                }
            }

            return merged;
        }

        private void dfs(Map<String, Set<String>> graph, String cur, Set<String> visited, List<String> res) {
            res.add(cur);
            for (String next : graph.get(cur)) {
                if (visited.add(next)) {
                    dfs(graph, next, visited, res);
                }
            }
        }
    }

    // Union find
    class Solution2 {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            int len = accounts.size();

            int[] parents = new int[len];
            for (int i = 0; i < len; i++) {
                parents[i] = i;
            }

            // Email to index(person/owner) mapping --  use to find the first onwer
            Map<String, Integer> firstOwner = new HashMap<>();

            for (int i = 0; i < len; i++) {
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    String email = accounts.get(i).get(j);
                    // Current email has an owner
                    if (firstOwner.containsKey(email)) {
                        int old = firstOwner.get(email);
                        // Find parent of that older owner
                        int p1 = find(parents, old);
                        // Find parent of current onwer
                        int p2 = find(parents, i);
                        // Union: current owner's parent is that old onwer's parent
                        if (p1 != p2) {
                            parents[p2] = p1;
                        }
                    } else {
                        // Associate email and the first onwer
                        firstOwner.put(email, i);
                    }
                }
            }

            // TreeSet to sort the emails
            // Find parent, put all the emails to the parent
            // Parent to emails mapping -- merged result
            Map<Integer, TreeSet<String>> users = new HashMap<>();
            for (int i = 0; i < accounts.size(); i++) {
                // Find parent
                int parent = find(parents, i);
                List<String> emails = accounts.get(i);
                users.putIfAbsent(parent, new TreeSet<String>());
                // All the emails goes to parent
                users.get(parent).addAll(emails.subList(1, emails.size()));
            }

            // Convert Map to list, swith Integer to name
            List<List<String>> res = new ArrayList<>();
            // Attach name
            for (Integer i : users.keySet()) {
                String name = accounts.get(i).get(0);
                List<String> emails = new ArrayList<>(users.get(i));
                emails.add(0, name);
                res.add(emails);
            }
            return res;
        }

        private int find(int[] parents, int i) {
            if (parents[i] != i) {
                parents[i] = find(parents, parents[i]);
            }
            return parents[i];
        }
    }
}
