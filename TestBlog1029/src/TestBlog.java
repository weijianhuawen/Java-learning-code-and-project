import java.util.Arrays;

public class TestBlog {
    public static void main(String[] args) {
        //创建数组
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,0};
        //访问数组长度
        System.out.println(arr.length);
        //访问数组元素
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        //遍历数组 1.for循环   2.foreach循环   3.toString函数

        //方式1：for循环
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        //方式2：foreach循环
        for (int a: arr) {
            System.out.print(a + "  ");
        }
        System.out.println();
        //方式3：toString函数
        System.out.println(Arrays.toString(arr));
    }
}
