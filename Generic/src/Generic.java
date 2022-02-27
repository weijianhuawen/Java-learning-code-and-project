/**
 * 不使用泛型
 */
class A {
}
class Print {
    private A a;

    public Print(A a) {
        setA(a);
        System.out.println(this.a);
    }
    public void setA(A a) {
        this.a = a;
    }
    public A getA() {
        return this.a;
    }
}

public class Generic {
   public static void main(String[] args) {
        Print print = new Print(new A());
    }
}
