public class Test4 {
    public static void main(String[] args) {
        String str1 = "weijianhuawen";
        String str2 = "WJHW";
        String str3 = "weijianhuawen";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));//将确定不为null的对象放前面，可防止空指针异常，但是这样做有时候会忽略方法内对象为null的情况
        System.out.println(str1.equals(null));
        String str = "hello world hello bit" ;
        String[] result = str.split(" ",1) ;
        for(String s: result) {
            System.out.println(s);
        }
        int a = -10;
        int b = -11;
        a %= b %= 4;
        System.out.println(a);
        System.out.println(b);
    }
}
