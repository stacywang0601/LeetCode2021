/**
 * 2021-05-19 Wed
 * The straight forward idea is to take x % 60 = 60 - t % 60,
 * which is valid for the most cases.
 * But if t % 60 = 0, x % 60 = 0 instead of 60.
 * */
public class Leet1010 {
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int[] reminders = new int[60];
            int count = 0;

            for (int t : time) {
                if (t % 60 == 0) {
                    count += reminders[0];
                } else {
                    count += reminders[60 - t % 60];
                }
                reminders[t % 60]++;
            }
            return count;
        }
    }
}
