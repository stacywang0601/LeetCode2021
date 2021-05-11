import java.util.Arrays;

/**
 * 2021-05-10 Mon
 */
public class Leet1854 {
    // Approach 1: Sort + sliding window
    public int maximumPopulation(int[][] logs) {
        int len = logs.length;
        int[] start = new int[len];
        int[] end = new int[len];

        int k = 0;
        for (int[] log : logs) {
            start[k] = log[0];
            end[k++] = log[1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int e = 0, max = 0, count = 0, earliest = 0, i = 0;
        while (i < len) {
            // Current range overlap with the window
            if (start[i] < end[e]) {
                count++;
                // Update global max and earliest year
                if (max < count) {
                    max = count;
                    // If include the current range, then start[i] is the latest start, which is the earliest
                    earliest = start[i];
                }
                i++;
            } else {
                // Sliding window, move window to right, but no index change
                count--;
                e++;
            }

        }
        return earliest;
    }

    // Approach 2: accumulate sum
    public int maximumPopulation2(int[][] logs) {
        // population from 1950 - 2050
        int[] count = new int[2050-1950+1];

        for(int[] log : logs){
            count[log[0] - 1950] += 1;
            count[log[1] - 1950] -= 1;
        }

        int max = count[0], earliest = 1950;

        for(int i = 1; i < count.length; i++){
            // Accumulate sum
            count[i] += count[i - 1];

            if(count[i] > max){
                max = count[i];
                earliest = i + 1950;
            }
        }
        return earliest;
    }
}
