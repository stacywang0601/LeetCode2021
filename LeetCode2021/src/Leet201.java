public class Leet201 {
    /**
     * 2021-06-19 Sat
     * The last bit of an odd number & an even number is 0.
     * when left != right, there is at least an odd number and an even number in the range of [left, right],
     * so the last bit position result is 0.
     * Move left and right right to a position.
     * Keep doing step 1,2,3 until left equal to right, use a count to record the iteration time.
     * this problem is asking us to find the common prefix of left and right 's binary code.
     */
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int count = 0;
            while (left != right) {
                left >>= 1;
                right >>= 1;
                count++;
            }
            return left <<= count;
        }
    }

}
