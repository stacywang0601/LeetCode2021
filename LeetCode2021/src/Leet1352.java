import java.util.*;
/**
 * 2021-05-26 Wed
 * Clear the list and re-initialize it as [1] when it's 0
 * */
public class Leet1352 {
    class ProductOfNumbers {
        List<Integer> list;

        public ProductOfNumbers() {
            list = new ArrayList<>();
            list.add(1);
        }

        public void add(int num) {
            if(num != 0) {
                list.add(list.get(list.size() - 1) * num);
            }else {
                list = new ArrayList<>();
                list.add(1);
            }
        }

        public int getProduct(int k) {
            int n = list.size();
            if(k >= n) return 0;
            return list.get(n-1) / list.get(n-1-k);
        }
    }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
}
