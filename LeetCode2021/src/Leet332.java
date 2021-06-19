import java.util.*;
/**
 * 2021-05-09 Sun
 * 2021-06-19 Sat
 * */
public class Leet332 {
    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, PriorityQueue<String>> map = new HashMap<>();
            for(List<String> ticket: tickets) {
                map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                map.get(ticket.get(0)).add(ticket.get(1));
            }
            List<String> res = new ArrayList<>();
            dfs("JFK", map, res);
            return res;
        }

        private void dfs(String depart, Map<String, PriorityQueue<String>> map, List<String> res) {
            PriorityQueue<String> arrivals = map.get(depart);

            if(arrivals == null) {
                res.add(0, depart);
                // !!!! return!!!!
                return;
            }

            while(!arrivals.isEmpty()) {
                dfs(arrivals.remove(), map, res);
            }
            res.add(0, depart);
        }
    }
}
