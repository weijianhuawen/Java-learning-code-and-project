public class Main5 {
    public static void main1(String[] args) {
        Color color = Color.valueOf("RED");
        System.out.println(color);
    }

    public static void main(String[] args) {
        Color[] colors = Color.values();
        for (Color c : colors) {
            System.out.println(c);
        }
    }
}
