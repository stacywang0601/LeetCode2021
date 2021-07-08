public class Leet134 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int sum = 0, localSum = 0;
            int start = 0;

            for (int i = 0; i < gas.length; i++) {
                int diff = gas[i] - cost[i];
                sum += diff;
                localSum += diff;

                if (localSum < 0) {
                    start = i + 1;
                    localSum = 0;
                }
            }
            return sum < 0 ? -1 : start;
        }
    }
}
