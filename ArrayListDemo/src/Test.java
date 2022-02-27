import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {

        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a==b);
        System.out.println(c==d);
    }
    public static void main2(String[] args) {
        MyArrayList<Integer> ls1 = new MyArrayList<>();
        MyArrayList<String> ls2 = new MyArrayList<>();
        ls1.add(2022);
        ls1.add(2333);
        ls1.add(6666);
        System.out.println(ls1);
        ls2.add("天");
        ls2.add("天");
        ls2.add("开");
        ls2.add("心");
        System.out.println(ls2);
        ls1.remove(1);
        ls2.remove(2);
        System.out.println(ls1);
        System.out.println(ls2);
        System.out.println(ls1.search(2024));
        System.out.println(ls2.search("心"));
        ls1.set(0, 4399);
        ls2.set(1,"乐");
        System.out.println(ls1);
        System.out.println(ls2);
    }
    public static void main1(String[] args) {
        Integer a = 2022;//隐式的装包
        int b = a;//隐式的拆包

        Integer c = new Integer(2022);
        Integer d = Integer.valueOf(2022);//显式装包

        int e = c.intValue();
        double f = c.doubleValue();//显式拆包
    }
}
