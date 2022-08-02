import java.io.File;

public class Main2 {
    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }


    public static final Integer a = new Integer(1);
    public static final Double b = new Double(2.0);
    public static void main(String[] args) {
        Object o1 = true ? a: b;
        Object o2;
        if (true) {
            o2 = a;
        } else {
            o2 = b;
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);
    }
}
