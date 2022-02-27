public class Func {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    public static int add(int a, int b, int c, int d) {
        return a + b + c +d;
    }
    public static void main(String[] args) {
        int x = add(1,2);
        int y = add(1, 2, 3);
        int z = add(1, 2, 3 ,4);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
