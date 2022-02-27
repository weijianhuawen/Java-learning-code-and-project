import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        //插入键值对
        map.put("1024","程序员节");
        map.put("大年初一", "春节");
        map.put("一月一日", "元旦节");
        //获取键值对数目以及判断地图是否为空
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
