import java.util.*;

public class Test {
    //key是关键字  value是出现的次数
    public static Map<Integer,Integer> func1(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        //判断array中的元素 是否在map当中，如果不在就是1.在就是在原来的基础上+1
        for (int x: array) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x)+1);
            } else {
                map.put(x, 1);
            }
        }
        return map;
    }

    //去重
    public static Set<Integer> func2(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int x: array) {
            set.add(x);
        }
        return set;
    }
    //查找第一个重复元素
    public static int func3(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int x: array) {
            if (set.contains(x)) return x;
            set.add(x);

        }
        return -1;//没有重复
    }
    public static void main(String[] args) {
        int[] array = new int[1_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        Map<Integer,Integer> map = func1(array);
        System.out.println(map);
    }
}
