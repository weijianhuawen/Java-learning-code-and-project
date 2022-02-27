import java.util.ArrayList;

public class TestDemo {
    public static void main(String[] args) {
        String str1 = "welcome to bit!";
        String str2 = "come";
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if(!str2.contains(str1.charAt(i) + "") ) {
                list.add(str1.charAt(i));
            }
        }
        System.out.println(list);
    }
}
