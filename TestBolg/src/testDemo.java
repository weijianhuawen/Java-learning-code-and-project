public class testDemo {
    public static void main(String[] args) {

    }
    public static void main5(String[] args) {
        int i = 0;
        for (i = 0; i < 100; i++){
            System.out.println("黄文杨吃屎！");
        }
    }
    public static void main4(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(a <= b);
        System.out.println(a >= b);
    }
    public static void main3(String[] args) {
        char c = 'A';
        char d = '花';
        System.out.println(c);
        System.out.println(d);
    }
    public static void main2(String[] args) {
        int b = 24;
        {
            int a = 48;
            System.out.println(a);//编译通过
            System.out.println(b);//编译通过
        }
        //System.out.println(a);//编译出错
        System.out.println(b);//编译通过
    }
    public static void main1(String[] args) {
        String str1 = "welcome";
        String str2 = "to";
        String str3 = "my";
        String str4 = "blog!";
        String str5 = str1 + str2 +str3 +str4;
        System.out.println(str5);
        String str6 = "value = " + 10 + 20;//数据与字符串拼接，最终会成为一个字符串！
        System.out.println(str6);
        String str7 = 10 + 20 + " is a value!";//这个有一点特殊，因为10与20都是整型且在字符串前，所以会先执行加法运算再和字符串拼接，当然最终会还是成为一个字符串！
        System.out.println(str7);
    }
}
