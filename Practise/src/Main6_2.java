import java.util.*;

public class Main6_2 {
    /**
     * 输入一篇英文文章，碰到"!!!!!"的时候停止，输出文章中出现的不重复单词的个数(注意：单词不区分大小写，如：The和the为一个单词)
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        String str = sc.next();
        while (!str.equals("!!!!!")) {
            str = str. toLowerCase();
            set.add(str);
            str = sc.next();
        }
        System.out.println(set.size());
    }
}
