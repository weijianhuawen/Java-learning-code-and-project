import java.util.PriorityQueue;

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
    //创建内部类
    public Inner1 creatInner1(String s) {
        return new Inner1(s);
    }
    public Inner2 creatInner2(int i) {
        return new Inner2(i);
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner1 inner1 =  outer.creatInner1("Inner1");
        Outer.Inner2 inner2 = outer.creatInner2(2);

        System.out.println(inner1.readStr());
        System.out.println(inner2.readVal());
    }
}
