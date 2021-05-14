/**
 * 2021-05-13 Thu
 * */
public class Leet162 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public int findPeakElement2(int[] nums) {
        int l = 0, h = nums.length - 1;
        while(l < h) {
            int m = (l + h) /2;
            if(nums[m] >= nums[m+1]) {
                h = m;
            }else {
                l = m + 1;
            }
        }
        return l;
    }
}
