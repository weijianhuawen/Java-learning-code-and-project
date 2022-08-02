package ls288;

import javafx.scene.control.SpinnerValueFactory;

import java.util.*;

public class Main {
}
class Solution1 {
    public int largestInteger(int num) {
        int n = num;
        List<Integer> list= new ArrayList<>();
        while (n != 0) {
            list.add(n%10);
            n /= 10;
        }
        Collections.reverse(list);

        for (int i = 0; i < list.size() - 1; i++) {
            int ret = list.get(i) & 1;
            for (int j = i; j < list.size(); j++) {
               if (ret == (list.get(j) & 1) && list.get(j).compareTo(list.get(i)) > 0) {
                   int tmp = list.get(i);
                   list.set(i, list.get(j));
                   list.set(j, tmp);
               }
            }

        }
        int ans = 0;
        for (int x: list) {
            ans = ans*10 + x;
        }
        return ans;
    }
}

class Solution3 {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        int i = 0;
        while (!queue.isEmpty() && k > 0) {
            int val = queue.poll();
            queue.offer(val+1);
            --k;
        }
        long ans = 1;
        for (int x: queue) {
            ans *= x;
        }
        return (int)(ans % (1e9+7));
    }
}

