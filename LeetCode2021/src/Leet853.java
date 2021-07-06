import java.util.Arrays;
import java.util.Comparator;

// 2021-04-29-Thu
/*
 * Calculate each car's time needed to arrive the target
 * Sort cars by the start positions pos
 * Loop on each car from the END to the beginning
 * cur records the current biggest time (the slowest)
 * If another car needs less or equal time than cur,
 * it can catch up this car fleet.
 * If another car needs more time,
 * it will be the new slowest car,
 * and becomes the new lead of a car fleet
 */
class Leet853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        double[][] cars = new double[len][2];
        for (int i = 0; i < len; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        Arrays.sort(cars, Comparator.comparingDouble(a -> a[0]));
        Arrays.sort(cars, (a, b) -> (int) (a[0] - b[0]));

        int res = 0;
        double cur = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (cars[i][1] > cur) {
                res++;
                cur = cars[i][1];
            }
        }
        return res;
    }
}
