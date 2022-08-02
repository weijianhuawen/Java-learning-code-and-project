import java.util.*;

public class Main3{

    public static void main(String[] args) {
        int[] arr = {-5,-2};
        Solution solution = new Solution();
        boolean ans = solution.canReorderDoubled(arr);
        System.out.println(ans);
    }
}
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], 1);
            else map.put(arr[i], map.get(arr[i]) + 1);
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && map.containsKey(arr[i]) && map.containsKey(2 * arr[i])) {
                map.put(arr[i], map.get(arr[i]) - 1);
                map.put(2 * arr[i], map.get(2 * arr[i]) - 1);
                if (map.get(arr[i]) <= 0) {
                    map.remove(arr[i]);
                }
                if (arr[i] != 0 && map.get(arr[i] * 2) <= 0) {
                    map.remove(2 * arr[i]);
                }
            } else if (arr[i] < 0 && map.containsKey(arr[i]) && map.containsKey(arr[i] / 2)) {
                if (arr[i] % 2 == -1) return false;
                map.put(arr[i], map.get(arr[i]) - 1);
                map.put(arr[i] / 2, map.get(arr[i] / 2) - 1);
                if (map.get(arr[i]) <= 0) {
                    map.remove(arr[i]);
                }
                if (map.get(arr[i] / 2) <= 0) {
                    map.remove(arr[i] / 2);
                }
            }
        }
        if (map.isEmpty()) return true;
        else return false;
    }
}