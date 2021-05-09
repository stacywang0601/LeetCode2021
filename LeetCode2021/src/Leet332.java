import java.util.*;

public class Leet332 {
    List<String> res = new ArrayList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return res;
    }

    private void dfs(String depart) {
        PriorityQueue<String> arrivals = map.get(depart);
        // Stop condition: a node doesn't have any arrival, means it is the end
        if (arrivals == null) {
            res.add(0, depart);
            return;
        }
        while (!arrivals.isEmpty()) {
            dfs(arrivals.remove());
        }
        // After getting back from the last recursion
        res.add(0, depart);
    }
}
