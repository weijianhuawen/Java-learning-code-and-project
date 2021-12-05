import java.util.Arrays;

public class Test11 {
    public static void main(String[] args) {
        String str = "my email is weijianhuawen@163.com";
        String[] arr1 = str.split(" ");
        System.out.println(Arrays.toString(arr1));
        String[] arr2 = str.split("@");
        System.out.println(Arrays.toString(arr2));
        String[] arr3 = str.split(" |@|\\.");//有多个分隔符，可以使用|链接
        System.out.println(Arrays.toString(arr3));
        String[] arr4 = str.split("");
        System.out.println(Arrays.toString(arr4));//没有分隔符，将字符串全部分开
        //多个分隔符分割还可以以多次分割的形式分开
        String[] res = str.split("@");
        for (int i = 0; i < res.length; i++) {
            String[] temp = res[i].split(" ");
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[j] + " ");
            }
        }
        System.out.println();
        String[] arr5 = str.split(" ", 2);
        System.out.println(Arrays.toString(arr5));
        String[] arr6 = str.split(" ", 3);
        System.out.println(Arrays.toString(arr6));
        String[] arr7 = str.split(" ", 4);
        System.out.println(Arrays.toString(arr7));
        String[] arr8 = str.split(" ", 100);//如果数组限制数超过实际最大分割字符串的数组长度，将输出实际分割的长度最大的字符串数组
        System.out.println(Arrays.toString(arr8));
        String str2 = "djfj\\j\\p\\]a";
        System.out.println(Arrays.toString(str2.split("\\\\")));//由于\是特殊字符需要\\\\才能表示一个普通的\
    }
}
