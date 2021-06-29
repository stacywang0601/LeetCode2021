import java.util.ArrayList;
import java.util.List;

public class Leet057 {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> res = new ArrayList<>();
            int len = intervals.length;
            int i = 0;
            int start = newInterval[0], end = newInterval[1];

            while (i < len && intervals[i][1] < start) {
                res.add(intervals[i++]);
            }

            while (i < len && intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
                i++;
            }
            res.add(new int[]{start, end});
            while (i < len) {
                res.add(intervals[i++]);
            }
            return res.toArray(new int[res.size()][2]);
        }
    }
}
