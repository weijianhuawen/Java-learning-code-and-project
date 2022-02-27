/**
 * 使用泛型
 */
class C{ }
class Print2<T> {
    private T c;

    public void print(T c) {
        setC(c);
        System.out.println(this.c);
    }

    public void setC(T c) {
        this.c = c;
    }
}
public class Generic2{
    public static void main(String[] args) {
        Print2 print2 = new Print2();
        print2.print(2022);
        print2.print("字符串");
    }
    public static void main2(String[] args) {
        Print2<C> print2 = new Print2<>();//打印C类型
        print2.print(new C());
        Print2<Integer> print3 = new Print2<>();//打印整型类型
        print3.print(2022);
        Print2<String> print4 = new Print2<>();//打印字符串类型
        print4.print("这是一个字符串对象！");
    }
}
/**
 * output:
 *C@1b6d3586
 * 2022
 * 这是一个字符串对象！
 */