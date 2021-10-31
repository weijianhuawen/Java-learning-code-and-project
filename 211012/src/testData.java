public class testData {
    public static void main(String[] args) {
        float f = 3.14F;//or 3.14f F or f 不能省，否则会编译错误
        System.out.println(f);
        System.out.println(Float.MAX_VALUE);//MAX
        System.out.println(Float.MIN_VALUE);//MIN
    }
    public static void main5(String[] args) {
        double e = 3.14;
        System.out.println(e);
        System.out.println(Double.MAX_VALUE);//MAX
        System.out.println(Double.MIN_VALUE);//MIN
    }
    public static void main4(String[] args) {
        byte d = 32;
        System.out.println(d);
        System.out.println(Byte.MAX_VALUE);//MAX
        System.out.println(Byte.MIN_VALUE);//MIN
    }
    public static void main3(String[] args) {
        long c = 345L;//or 345l(不推荐，容易与1混)
        System.out.println(c);
        System.out.println(Long.MAX_VALUE);//max
        System.out.println(Long.MIN_VALUE);//min
    }
    public static void main2(String[] args) {
        short b = 8;
        System.out.println(b);
        System.out.println(Short.MAX_VALUE);//max
        System.out.println(Short.MIN_VALUE);//min
    }
    public static void main1(String[] args) {
        int a = 159;
        System.out.println(a);
        System.out.println(Integer.MAX_VALUE);//max
        System.out.println(Integer.MIN_VALUE);//min
    }
}
