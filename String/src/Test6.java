import java.io.UnsupportedEncodingException;
import java.util.Arrays;
public class Test6 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {97,98,99,100,101,102,103};
        String str1 = new String(bytes);
        System.out.println(str1);
        String str2 = new String(bytes, 2, 3);
        System.out.println(str2);
        byte[] arr = str1.getBytes();
        System.out.println(Arrays.toString(arr));
        String str3 = "wjhw";
        String str4 = "未见花闻";
        System.out.println(Arrays.toString(str3.getBytes("utf-8")));//全英文字符串转字节编码，utf-8
        System.out.println(Arrays.toString(str3.getBytes("gbk")));//全英文字符串转字节编码，gbk
        System.out.println(Arrays.toString(str4.getBytes("utf-8")));//全中文字符串转字节编码，utf-8
        System.out.println(Arrays.toString(str4.getBytes("gbk")));//全中文字符串转字节编码，gbk
    }
}
