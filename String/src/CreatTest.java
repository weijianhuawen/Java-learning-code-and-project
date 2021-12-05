public class CreatTest {
    public static void main(String[] args) {
        //字符串创建
        String str1 = "CSDN";//方法1
        String str2 = new String("weijianhuawen");//方法2
        char[] ch = {'j','a','v','a'};
        String str3 = new String(ch);//方法3

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
