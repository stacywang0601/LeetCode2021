public class Leet137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int n : nums) {
                count += (n >> i) & 1;
            }
            res += (count % 3) << i;
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        int one = 0, two = 0;

        for(int num: nums) {
            // first appearence:
            // add num to seen_once one
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            one = ~two & (one ^ num);
            two = ~one & (two ^ num);
        }
        return one;
    }
}
