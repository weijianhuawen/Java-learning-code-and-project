package out6;

import out1.SequeArray;
class P{}
public class Outer {
    class Inner{

    }
}
class Person extends Outer.Inner {
    private String str;
    private int id;
    public Person(Outer out, String str, int id) {
        out.super();
        this.str = str;
        this.id = id;
    }
    public void readVal() {
        System.out.println(this.str + this.id);

    }
}