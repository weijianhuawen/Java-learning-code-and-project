/**
 * 使用Object类
 */
class B{ }
class Print1 {
    private Object b;

    public Print1(Object b) {
        setB(b);
        System.out.println(this.b);
    }

    public void print(Object b) {
        setB(b);
        System.out.println(this.b);
    }

    public void setB(Object b) {
        this.b = b;
    }
}
public class Generic1 {
    public static void main(String[] args) {
        Print1 print1 = new Print1(new B());//打印B类型
        int i = 2022;
        print1.print(i);//打印整型类型
        print1.print("这是一个字符串对象！");//打印字符串类型
    }
}
//output:
//B@1b6d3586
//2022
//这是一个字符串对象！