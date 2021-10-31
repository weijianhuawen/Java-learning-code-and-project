public class StringArray {
    public static String myToString(int[] arr) {
        if (arr == null) {
            return "[]";//空引用返回[]
        }
        String str = "[";//初始化字符串为[
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ",";//注意最后一个数组元素后无逗号
        }
        str += arr[arr.length - 1] + "]";//查漏补缺，补上最后一个元素和]
        return str;
    }
    public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(myToString(arr));
    }
}
