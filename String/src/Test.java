
public class Test {
    public static void main(String[] args) {
        String str1 ="     I hava a pen.       ";
        System.out.println(str1.trim());
        System.out.println("============");
        String str2 = "apple";
        System.out.println(str2.toUpperCase());
        System.out.println("============");
        String str3 = "APP";
        System.out.println(str3.toLowerCase());
        System.out.println("============");
        String str4 = "weijianhuawen";
        System.out.println(str4.length());
        System.out.println("============");
        String str5 = "cs";
        String str6 = "dn";
        System.out.println(str5.concat(str6));
        System.out.println("============");
        String str7 = "";
        System.out.println(str7.isEmpty());
    }
}
