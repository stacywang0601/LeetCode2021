import java.util.PriorityQueue;
import java.util.Random;

public class Leet215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(k);

            for (int num : nums) {
                pq.offer(num);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            return pq.peek();
        }
    }

    class Solution2 {
        int[] nums;
        int K;

        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            this.nums = nums;
            this.K = len - k;
            return quicksort(0, len - 1);
        }

        private int quicksort(int l, int h) {
            if (l == h) return nums[l];

            Random rand = new Random();
            int pivot = l + rand.nextInt(h - l);
            pivot = partition(l, h, pivot);

            if (pivot == K) {
                return nums[K];
            }
            if (pivot < K) {
                return quicksort(pivot + 1, h);
            }
            return quicksort(l, pivot - 1);
        }

        private int partition(int l, int h, int pivot) {
            int num = nums[pivot];
            swap(pivot, h);

            int slow = l;
            for (int i = l; i < h; i++) {
                if (nums[i] < num) {
                    swap(i, slow);
                    slow++;
                }
            }
            swap(slow, h);
            return slow;
        }

        private void swap(int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
