package out2;
public class Outer {
    private String outStr;
    public Outer(String str) {
        this.outStr = str;
    }

    public void printOuter() {
        System.out.println(this.outStr);
    }

    class Inner {
        private String str;
        public Inner(String s) {
            this.str = s;
        }
        public String readStr() {
            return this.str;
        }
        //使用.this获取父类对象引用
        public Outer outer() {
            return Outer.this;
        }
    }



    public static void main(String[] args) {
        Outer outer = new Outer("outerString");
        Outer.Inner inner = outer.new Inner("innerString");

        Outer out = inner.outer();
        out.printOuter();
    }
}