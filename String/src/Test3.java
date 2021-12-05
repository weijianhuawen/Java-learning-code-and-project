public class Test3 {
    public static void main(String[] args) {
        String str1 = "csdn";
        String str2 = "csdn";
        System.out.println(str1 == str2);//(1)
        System.out.println("============");
        String str3 = new String("csdn");
        System.out.println(str1 == str3);//(2)
        System.out.println("=============");
        String str4 = "cs" + "dn";
        System.out.println(str1 == str4);//(3)
        System.out.println("============");
        String str5 = "cs";
        String str6 = str5 + "dn";
        System.out.println(str1 == str6);//(4)
    }
}

