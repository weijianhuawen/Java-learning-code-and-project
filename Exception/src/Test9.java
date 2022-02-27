public class Test9 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        String str = null;
        try {
            System.out.println(str.equals("aaa"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个空指针异常！");
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个运行时异常！");
        }
    }
}
