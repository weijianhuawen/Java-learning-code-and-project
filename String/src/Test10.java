public class Test10 {
    public static void main(String[] args) {
        String str = "Wisdom comes from diligence, and greatness comes from the ordinary";
        System.out.println(str.replaceAll("from", "源于"));//得到的一个新对象，不会修改源字符串内容
        System.out.println(str);
        System.out.println(str.replace("from", "源于"));//得到的一个新对象，不会修改源字符串内容
        System.out.println(str);
        System.out.println(str.replaceFirst("from", "源于"));//得到的一个新对象，不会修改源字符串内容
        System.out.println(str);
    }
}

