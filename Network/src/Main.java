import java.util.*;
public class Main {
    static int solve(int[] arr, int n, int m) {
        int ans = 0;
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (hash.contains(m-arr[i])) {
                ans++;
            }
            hash.add(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(solve(arr, 10, 7));
    }
}
