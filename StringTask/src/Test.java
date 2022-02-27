import java.util.Scanner;

public class Test {
    public static StringBuilder numStr ;
    public static StringBuilder alpStr ;
    public static boolean isOther(char[] s) {
        for (char c: s) {
            if (c < '0' || c > '9' && c < 'A' || c > 'z') {
                return true;
            }else if (c <= '9') {
                numStr.append(c);
            }else {
                alpStr.append(c);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            numStr = new StringBuilder();
            alpStr = new StringBuilder();
            char[] s = str.toCharArray();
            boolean flag = isOther(s);
            if (flag) {
                System.out.println("输入不合法！请重新输入！");
                continue;
            }
            String s1 = numStr.toString();
            String s2 = alpStr.toString();
            int len1 = s1.length();
            int len2 = s2.length();
            System.out.println("数字字符串：" + s1);
            System.out.println("字母字符串：" + s2);
            System.out.println(str + "的数字个数：" + len1 + ",字母个数为：" + len2);
            String s3 = s1.concat(s2);
            System.out.println("s1与s2拼接后：" + s3);

            String s4 = s3.substring(len2 - 1);
            System.out.println("s3的一个子串为：" + s4);

            String s5 = s3.toLowerCase();
            System.out.println("s3中大写字母转小写：" + s5);

            System.out.println("s3与s5是否相等：" + s3.equals(s5));
            System.out.println("忽略大小写，s3与s5是否相等：" +s3.equalsIgnoreCase(s5));
        }
    }
}
