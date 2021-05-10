import java.util.*;
/**
 * 2021-05-09 Sun
 * */
public class Leet332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket: tickets) {
            if(!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK", res, map);
        return res;
    }

    private void dfs(String cur, List<String> res, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> arrivals = map.get(cur);
        if(arrivals == null) {
            // Stop condition: a node doesn't have any arrival, means it is the end. RETURN!
            res.add(0, cur);
            return;
        }
        while(!arrivals.isEmpty()) {
            // remove
            dfs(arrivals.remove(), res, map);
        }
        // After getting back from the last recursion, all the arrivals are taken care of
        res.add(0, cur);
    }
}
