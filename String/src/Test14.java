public class Test14 {
    public static void main(String[] args) {
        String str = "abc";
        for (int i = 1; i <= 9; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(i);
            str = stringBuilder.toString();
        }
    }
}
