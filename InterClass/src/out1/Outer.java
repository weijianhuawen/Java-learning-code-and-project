package out1;
public class Outer {

    class Inner1 {
        private String str;
        public Inner1(String s) {
            this.str = s;
        }
        public String readStr() {
            return this.str;
        }
    }

    class Inner2 {
        private int val;
        public Inner2(int i) {
            this.val = i;
        }
        public int readVal() {
            return this.val;
        }
    }


    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner1 inner1 =  outer.new Inner1("Inner1");
        Outer.Inner2 inner2 = outer.new Inner2(2);

        System.out.println(inner1.readStr());
        System.out.println(inner2.readVal());
    }
}
