package out3;

public class Outer {
    public int a = 12;
    public int b = 16;
    public int c = 20;

    class Inner{
        public int a = 8;
        public int c = 48;
        public int d = 2;

        public void printVal() {
            System.out.println("外部类变量a=" + Outer.this.a);
            System.out.println("外部类变量b=" + Outer.this.b);
            System.out.println("外部类变量c=" + Outer.this.c);
            System.out.println("内部类变量a=" + this.a);
            System.out.println("内部类变量c=" + this.c);
            System.out.println("内部类变量d=" + this.d);
        }
    }

    public Inner creatInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.Inner inner = outer.creatInner();
        inner.printVal();
    }
}