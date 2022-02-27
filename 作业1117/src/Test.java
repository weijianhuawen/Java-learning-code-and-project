public class Test {
    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main(String[] args){
        System.out.println(isAdmin("Admin"));
    }
}
class Solution {
    public static boolean isSame(String words) {
        for (int j = 0; j < words.length() - 1; j++) {
            for (int s = j + 1; s < words.length(); s++) {
                if (words.charAt(j) == words.charAt(s)) {
                    return true;
                }
            }
        }
        return false;
    }
    public int maxProduct(String[] words) {
        int[] cnt = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (isSame(words[i]) == false) {
                cnt[i] = words[i].length();
            }
            else {
                cnt[i] = 0;
            }
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (max < cnt[i] * cnt[j]) {
                    max = cnt[i] * cnt[j];
                }
            }
        }
        return max;
    }
}
