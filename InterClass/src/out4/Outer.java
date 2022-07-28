package out4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Outer {
    static class Inner{
        private String str;
        public Inner(String s) {
            str = s;
        }
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner("我是静态内部类！");
        System.out.println(inner.str);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
}
