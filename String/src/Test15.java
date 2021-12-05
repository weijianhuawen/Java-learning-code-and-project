public class Test15 {
    public static void main(String[] args) {
        String str = "abc";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        for (int i = 1; i <= 9; i++) {
            stringBuilder.append(i);
        }
        str = stringBuilder.toString();
        System.out.println(str);
    }
}
