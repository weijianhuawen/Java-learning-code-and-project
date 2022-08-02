package ls291;

import java.util.HashMap;

public class Main {

}
class Solution1 {
    private static boolean isBig(String a, String b) {
        //判断a是否大于b
        if (a.length() == b.length()) {
            for(int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == b.charAt(i)) {
                    continue;
                }
                return a.charAt(i) > b.charAt(i);
            }
        }
        return a.length() > b.length();
    }
    public String removeDigit(String number, char digit) {
        String ans = "0";
        for (int i = 0; i < number.length(); i++) {
            String ret = number.substring(0,i) + number.substring(i+1,number.length());
            if (number.charAt(i) == digit && isBig(ret, ans)) {
                ans = ret;
            }
        }
        return ans;
    }
}

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < cards.length; i++) {
            hash.put(cards[i], hash.getOrDefault(i, 0) + 1);
        }
        int min = 100000;
        for (int i = 0; i < cards.length; i++) {
            if (hash.get(cards[i]) > 1) {
                int start = i;
                for (int j = i+1; j < cards.length && hash.get(cards[i]) > 0; j++) {
                    if (cards[j] == cards[start]) {
                        if ((j-start+1) < min) min = j - start + 1;
                        start = j;
                        hash.put(cards[i], hash.get(cards[i]) - 1);
                    }
                }
            }
        }
        return min < 100000 ? min : -1;
    }
}