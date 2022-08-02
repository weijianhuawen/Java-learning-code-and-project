package ls287;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{2,3}, {1,3},{5,4}, {6,4}};
        solution.findWinners(arr);
    }
}
class Solution1 {
    public int convertTime(String current, String correct) {
        int ans = 0;
        int m = 0;

        int th1 = (current.charAt(0) - '0') * 10 + (current.charAt(1) - '0');
        int th2 = (correct.charAt(0) - '0') * 10 + (correct.charAt(1) - '0');
        if (th1 > th2) {
            int tm1 = (current.charAt(3) - '0') * 10 + (current.charAt(4) - '0');
            int tm2 = (correct.charAt(3) - '0') * 10 + (correct.charAt(4) - '0');
            m = (th1 -th2) * 60 + (tm2 - tm1);
            ans += m / 60;
            m = m % 60;
            ans += m / 15;
            m = m % 15;
            ans += m / 5;
            m = m % 5;
            ans += m;
        } else if (th1 < th2) {
            int tm1 = (current.charAt(3) - '0') * 10 + (current.charAt(4) - '0');
            int tm2 = (correct.charAt(3) - '0') * 10 + (correct.charAt(4) - '0');
            m = (th2 -th1) * 60 + (tm2 - tm1);
            ans += m / 60;
            m = m % 60;
            ans += m / 15;
            m = m % 15;
            ans += m / 5;
            m = m % 5;
            ans += m;
        } else {
            int tm1 = (current.charAt(3) - '0') * 10 + (current.charAt(4) - '0');
            int tm2 = (correct.charAt(3) - '0') * 10 + (correct.charAt(4) - '0');
            m = Math.abs(tm2 - tm1);
            ans += m / 15;
            m = m % 15;
            ans += m / 5;
            m = m % 5;
            ans += m;
        }
        return ans;
    }
}

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> map1 = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();

        for (int i = 0; i < matches.length; i++) {
            map1.put(matches[i][0], 0);
            map2.put(matches[i][0], 0);
        }
        for (int i = 0; i < matches.length; i++) {
            map1.put(matches[i][1], map1.getOrDefault(matches[i][1], 0) + 1);
            map2.put(matches[i][1], map2.getOrDefault(matches[i][1], 0) + 1);

        }
        for (int i = 0; i < matches.length; i++) {
            if (!map1.isEmpty() && map1.containsKey(matches[i][0]) && map1.get(matches[i][0]) != 0) {
                map1.remove(matches[i][0]);
            }
            if (!map2.isEmpty() && map2.containsKey(matches[i][1]) && map2.get(matches[i][1]) != 1) {
                map2.remove(matches[i][1]);
            }
            if (!map1.isEmpty()) map1.remove(matches[i][1]);
            if (!map2.isEmpty()) map2.remove(matches[i][0]);
        }
        List<Integer> win = new ArrayList<>(map1.keySet());
        List<Integer> lose = new ArrayList<>(map2.keySet());
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(win);
        ans.add(lose);
        return ans;
     }
}

class Solution2 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> win = new ArrayList<>();
        List<Integer> lose = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < matches.length; i++) {
            map.put(matches[i][0], 0);
        }
        for (int i = 0; i < matches.length; i++) {
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
        }
        for (int i = 0; i < matches.length; i++) {
            if (!map.isEmpty()) {
                if (map.get(matches[i][0]) == 0 && !win.contains(matches[i][0])) win.add(matches[i][0]);
                if (map.get(matches[i][1]) == 1 && !lose.contains(matches[i][1])) lose.add(matches[i][1]);
            }
        }
        Collections.sort(win);
        Collections.sort(lose);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(win);
        ans.add(lose);
        return ans;
    }
}
