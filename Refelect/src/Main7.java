import java.util.Comparator;

public class Main7 {
    public static void main(String[] args) {
        int a = 10;
        //a = 20;
        FuncInter funcInter = s -> System.out.println(s + a);
        funcInter.hello("变量输出：");
    }
}

@FunctionalInterface
interface FuncInter {
    public abstract void hello(String s);
}

class Hello implements FuncInter {
    @Override
    public void hello(String s) {
        System.out.println("hello,world!");
    }
}