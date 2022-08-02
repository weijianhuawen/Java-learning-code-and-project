public class SpringTest {
}
class Solution222 {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int ans = 0;
        for (int i = 0; i < fruits.length; i++) {
            int n = fruits[i][1];
            int j = fruits[i][0];
            while (n > 0) {
                ans += time[j];
                n /= limit;
            }
        }
        return ans;
    }
}