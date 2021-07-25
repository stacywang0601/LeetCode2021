import java.util.Arrays;

/**
 * Whenever there is a start meeting, we need to add one room. But before adding rooms, we check to see if any
 * previous meeting ends, which is why we check start with the previous end. When the start is bigger than end, it means
 * at this time one of the previous meeting ends, and it can take and reuse that room.
 */
public class Leet253 {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            int len = intervals.length;
            int[] start = new int[len], end = new int[len];

            int k = 0;
            for (int[] interval : intervals) {
                start[k] = interval[0];
                end[k++] = interval[1];
            }

            Arrays.sort(start);
            Arrays.sort(end);

            int pre = 0, res = 0;

            for (int i = 0; i < len; i++) {
                res++;
                if (start[i] >= end[pre]) {
                    res--;
                    pre++;
                }
            }
            return res;

        }
    }
}
