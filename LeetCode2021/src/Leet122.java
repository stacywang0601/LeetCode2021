/**
 * 2021-05-09 Sun
 * */

public class Leet122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int i = 0, res = 0;
        while (i < len) {
            while (i < len - 1 && prices[i + 1] < prices[i]) {
                i++;
            }
            int buy = prices[i];
            while (i < len - 1 && prices[i + 1] > prices[i]) {
                i++;
            }
            int sell = prices[i];
            res += sell - buy;
            i++;
        }
        return res;
    }
}
