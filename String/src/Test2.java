public class Test2 {
    public static void func(String str, char[] ch) {
        str = "bili";
        ch[0] = 'w';
    }
    public static void main(String[] args) {
        String s = "csdn";
        char[] c = {'a', 'b', 'c'};
        System.out.println(s);
        System.out.println(c);
        System.out.println("=================");
        func(s, c);
        System.out.println(s);
        System.out.println(c);
    }
}
