public class Test8 {
    public static void main(String[] args) {
        String str1 = "weijianhuawen";
        System.out.println(str1.contains("wei"));//true
        System.out.println(str1.contains("weihua"));//false
        System.out.println("============");
        System.out.println(str1.indexOf("jian"));//3
        System.out.println(str1.indexOf("hua"));//7
        System.out.println(str1.indexOf("wjhw"));//-1
        System.out.println(str1.indexOf('e'));//1
        System.out.println(str1.indexOf('u'));//8
        System.out.println("=============");
        System.out.println(str1.indexOf("hua", 7));//7
        System.out.println(str1.indexOf("jian", 7));//-1
        System.out.println(str1.indexOf('e', 1));//1
    }
}
