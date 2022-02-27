public class Test12 {
    public static int func() {
        try {
            return 10;
        }finally {
            return 20;
        }
    }
    public static void main(String[] args) {
        System.out.println(func());
    }
}
