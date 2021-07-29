import java.util.ArrayList;

// 2021-07-28 Wed
public class Leet1428 {
    /*
     * Solution1: Binary search with optimization
     * Time complexity : O(NlogM)
     * Space complexity : O(1)
     * */
    class Solution {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            int row = binaryMatrix.dimensions().get(0);
            int col = binaryMatrix.dimensions().get(1);
            int min = col;

            for (int i = 0; i < row; i++) {
                int l = 0, h = min - 1;
                while (l < h) {
                    int m = l + (h - l) / 2;
                    if (binaryMatrix.get(i, m) == 0) {
                        l = m + 1;
                    } else {
                        h = m;
                    }
                }
                if (binaryMatrix.get(i, l) == 1) {
                    min = Math.min(min, l);
                }
            }
            return min == col ? -1 : min;
        }
    }

    /**
     * Solution2: Liner Start at Top Right, Move Only Left and Down
     * Time complexity : O(N+M)
     * Space complexity : O(1)
     * O(M+N) can be worse than O(NlogM) if M is much large than N.
     */
    class Solution2 {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            int row = binaryMatrix.dimensions().get(0);
            int col = binaryMatrix.dimensions().get(1);
            int c = col - 1, r = 0;

            while (r < row && c >= 0) {
                if (binaryMatrix.get(r, c) == 0) {
                    r++;
                } else {
                    c--;
                }
            }
            return c == col - 1 ? -1 : c + 1;
        }
    }

    class BinaryMatrix {
        public int get(int row, int col) {
            return 0;
        }

        public ArrayList<Integer> dimensions() {
            return new ArrayList<Integer>();
        }
    }
}
