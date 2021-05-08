import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet056 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        int[] startArr = new int[len];
        int[] endArr = new int[len];

        int k = 0;
        for (int[] interval : intervals) {
            startArr[k] = interval[0];
            endArr[k] = interval[1];
            k++;
        }
        Arrays.sort(startArr);
        Arrays.sort(endArr);

        List<int[]> res = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (i == len - 1 || startArr[i + 1] > endArr[i]) {
                res.add(new int[]{startArr[start], endArr[i]});
                start = i + 1;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
