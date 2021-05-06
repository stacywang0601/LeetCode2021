/*
 * 2021-05-05 Wed
 * Two k loop
 */


public class Leet1423 {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        int rightSum = 0, sum = leftSum, len = cardPoints.length;
        for (int i = 0; i < k; i++) {
            leftSum -= cardPoints[k - 1 - i];
            rightSum += cardPoints[len - 1 - i];
            sum = Math.max(sum, leftSum + rightSum);
        }
        return sum;
    }

}
