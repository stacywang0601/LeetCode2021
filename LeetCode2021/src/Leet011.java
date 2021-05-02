/*
* 2021-05-02 Sun
* Two Pointer Approach
* 1.The area is always be limited by the height of the shorter line [Move the shorter line to center].
* 2.Further, the farther [from sides to center] the lines, the more will be the area obtained
* 3.Max area:  store the maximum area obtained till now
*/

public class Leet011 {
    public int maxArea(int[] height) {
        if(height == null) return 0;
        int len = height.length;
        int l = 0, r = len - 1;
        int res = 0;

        while(l < r) {
            if(height[l] < height[r]){
                res = Math.max(res, height[l]*(r-l));
                l++;
            }else {
                res = Math.max(res, height[r]*(r-l));
                r--;
            }
        }
        return res;
    }
}
