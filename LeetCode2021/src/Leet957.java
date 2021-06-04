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
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> map = new HashMap<>();
        while (n > 0) {
            map.put(Arrays.toString(cells), n--);
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            String next = Arrays.toString(cells2);
            if (map.containsKey(next)) {
                n %= map.get(next) - n;
            }
            cells = cells2;
        }
        return cells;
    }
}
