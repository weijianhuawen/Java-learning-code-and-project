public class Test7 {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aBcDEf";
        System.out.println(str1.equals("abcdef"));//true
        System.out.println(str1.equals("abef"));
        System.out.println("============");
        System.out.println(str1.equals(str2));//false
        System.out.println(str1.equalsIgnoreCase(str2));//true
        System.out.println("============");
        String str3 = "ca68";
        System.out.println(str3.compareTo("ca68"));
        System.out.println(str3.compareTo("da68"));
        System.out.println(str3.compareTo("ca67"));
        System.out.println(str3.compareTo("ca688"));
        System.out.println(str3.compareTo("ca6"));
        System.out.println(str3.compareToIgnoreCase("CA68"));
    }
}

