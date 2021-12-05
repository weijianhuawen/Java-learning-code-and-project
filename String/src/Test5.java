import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        char[] chArr = {'a', 'b', 'c', 'd', 'e'};
        String str1 = new String(chArr);
        System.out.println(str1);
        String str2 = new String(chArr, 2,2);
        System.out.println(str2);
        System.out.println(str1.charAt(3));
        char[] arr = str1.toCharArray();
        System.out.println(Arrays.toString(arr));
    }
}
