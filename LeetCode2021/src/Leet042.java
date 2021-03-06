/*
 * 2021-05-07 Fri
 */
public class Leet042 {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        if (height.length == 0) return 0;

        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int maxLeft = 0, maxRight = 0, sum = 0;
        while(l < r) {
            if(height[l] < height[r]) {
                maxLeft = Math.max(maxLeft, height[l]);
                sum += maxLeft - height[l];
                l++;
            }else {
                maxRight = Math.max(maxRight, height[r]);
                sum += maxRight - height[r];
                r--;
            }
        }
        return sum;
    }
}
