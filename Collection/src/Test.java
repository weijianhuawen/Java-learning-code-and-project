import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        Collection<Integer> coll = new ArrayList<>();
        //添加元素
        coll.add(115);
        coll.add(2022);
        coll.add(4848);
        //ArrayList有实现toString方法，因此可以使用引用名输出整个集合元素
        System.out.println(coll);
        //获取元素个数
        System.out.println(coll.size());
        //转换成数组,返回数组类型是Object[]
        Object[] arr = coll.toArray();
        System.out.println(Arrays.toString(arr));
        //判断并删除元素e
        System.out.println(coll.remove(4848));
        System.out.println(coll);
        //清空集合
        coll.clear();
        System.out.println(coll);
        //判断集合是否为空
        System.out.println(coll.isEmpty());
    }
}
