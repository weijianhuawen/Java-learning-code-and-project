import java.util.*;

// 1:无需package
// 2: 类名必须Main, 不可修改
public class Test {

}
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        int ans = 0;
        while (sc.hasNext()) {
            String str = sc.next();
            set.add(str);
        }
        System.out.println(set.size());
    }
    public static void main1(String[] args) {
        int[] arr = {18, 16, 12, 23, 48, 24, 2, 32, 6, 1};
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,6,7,8,9,10};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y-x);
        Sort sort = new Sort();
        sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] ret = sort.mergeArray(arr1, arr2);
        System.out.println(Arrays.toString(ret));
        //int ret = sort.test2(arr, 0, 9);
        //System.out.println(ret);
        //System.out.println(Arrays.toString(arr));
    }
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[0] - b[0]);
        int n = apples.length, time = 0, ans = 0;
        while (time < n || !q.isEmpty()) {
            if (time < n && apples[time] > 0) q.add(new int[]{time + days[time] - 1, apples[time]});
            while (!q.isEmpty() && q.peek()[0] < time) q.poll();
            if (!q.isEmpty()) {
                int[] cur = q.poll();
                if (--cur[1] > 0 && cur[0] > time) q.add(cur);
                ans++;
            }
            time++;
        }
        return ans;
    }
}

