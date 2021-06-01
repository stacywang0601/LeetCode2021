import java.util.HashSet;
import java.util.Set;

/**
 * 2021-06-01 Thu
 * */
public class Leet202 {
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            while (!set.contains(n)) {
                set.add(n);
                int next = 0;
                while (n > 0) {
                    int temp = n % 10;
                    next += temp * temp;
                    n /= 10;
                }
                n = next;
            }
            return n == 1;
        }
    }
}
