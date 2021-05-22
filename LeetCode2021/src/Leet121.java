/**
 * 2021-05-21 Fri
 */

public class Leet121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int buy = Integer.MIN_VALUE, sell = 0;

            for (int price : prices) {
                buy = Math.max(buy, -price);
                sell = Math.max(sell, buy + price);
            }
            return sell;

        }
    }
}
