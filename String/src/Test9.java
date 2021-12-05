public class Test9 {
    public static void main(String[] args) {
        String str2 = "shiyuyuanfang";
        System.out.println(str2.lastIndexOf("yuan"));//5
        System.out.println(str2.lastIndexOf('a'));//10
        System.out.println(str2.lastIndexOf("yu", 5));//5
        System.out.println(str2.indexOf('a', 8));//10
        System.out.println("============");
        System.out.println(str2.startsWith("shi"));//true
        System.out.println(str2.startsWith("yuan"));//false
        System.out.println(str2.startsWith("yuan", 5));//true
        System.out.println(str2.endsWith("fang"));//true
        System.out.println(str2.endsWith("yuan"));//false
    }
}
