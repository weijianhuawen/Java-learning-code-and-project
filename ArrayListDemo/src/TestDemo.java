import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2022);
        arrayList.add(1024);
        arrayList.add(2333);
        arrayList.add(1314);
        ListIterator<Integer> it = arrayList.listIterator();
        while (it.hasNext()) {
            Integer ret = it.next();
            System.out.print(ret + "  ");
        }
    }
    public static void main2(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2022);
        arrayList.add(1024);
        arrayList.add(2333);
        arrayList.add(1314);//arrayList = [2022,1024,2333,1314]
        //AddAll方法
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(arrayList);
        System.out.println(data);
        //subList方法
        List<Integer> sub = data.subList(1,3);//左开右闭,剪切第2,3个元素
        System.out.println(sub);
        //toArray方法
        Object[] arr = data.toArray();//转数组
        System.out.println(Arrays.toString(arr));
    }
    public static void main1(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(12);
        ArrayList<Integer> arrayList1 = new ArrayList<>(list);//使用LinkedList对象构造
        System.out.println(arrayList1);
        ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList1);//使用ArrayList对象构造
        System.out.println(arrayList2);
    }
}
