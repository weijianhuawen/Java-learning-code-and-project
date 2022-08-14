import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main8 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "zhangsan");
        map.put(2, "lisi");
        map.put(3, "shaonian");
        map.put(4,"wish");
        map.put(5, "hua");

//        map.forEach(new BiConsumer<Integer, String>() {
//            @Override
//            public void accept(Integer integer, String s) {
//                System.out.println("key:" + integer + " value:" + s);
//            }
//        });
        map.forEach((Integer integer, String s) -> System.out.println("key:" + integer + " value:" + s));
    }
    public static void main2(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("wangwu");
        list.add("ang");
        list.add("lambda");

//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                //按照字典逆序排序
//                return o2.compareTo(o1);
//            }
//        });
        list.sort(((o1, o2) -> o2.compareTo(o1)));

        System.out.println(list);
    }
    public static void main1(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("1024");
        list.add("hello");
        list.add("lambda");
//        list.forEach(new Consumer<String>(){
//            @Override
//            public void accept(String str){
//            //简单遍历集合中的元素。
//            System.out.print(str+" ");
//        } });

        list.forEach(s -> System.out.print(s + " "));
    }
}
