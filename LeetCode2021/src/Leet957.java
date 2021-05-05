import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 2021-05-04 Tue
 * Note that cells.length = 8, and cells[0] and cells[7] will become 0.
 * In fact, cells have only 2 ^ 6 = 64 different states.
 * And there will be a loop.
 */
public class Leet957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        while (N > 0) {
            int[] cells2 = new int[8];
            map.put(Arrays.toString(cells), N--);
            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            if (map.containsKey(Arrays.toString(cells))) {
                N %= map.get(Arrays.toString(cells)) - N;
            }
        }
        return cells;
    }
}
