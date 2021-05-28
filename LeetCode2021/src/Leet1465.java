import java.util.Arrays;
/**
 * 2021-05-27 Thu
 * */
public class Leet1465 {
    class Solution {
        public int maxArea(int h, int w, int[] hc, int[] vc) {
            Arrays.sort(hc);
            Arrays.sort(vc);
            int hmax = Math.max(hc[0], h - hc[hc.length - 1]);
            int wmax = Math.max(vc[0], w - vc[vc.length - 1]);

            for (int i = 0; i < hc.length - 1; i++) {
                hmax = Math.max(hmax, hc[i + 1] - hc[i]);
            }
            for (int i = 0; i < vc.length - 1; i++) {
                wmax = Math.max(wmax, vc[i + 1] - vc[i]);
            }
            return (int) ((long) hmax * wmax % 1000000007);
        }
    }
}
