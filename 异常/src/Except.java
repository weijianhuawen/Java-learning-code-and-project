class MyExcept extends RuntimeException {
    public MyExcept(String message) {
        super(message);
    }
}
public class Except {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            try {
                throw new MyExcept("异常");
            }catch (MyExcept e) {
                e.printStackTrace();
                i++;
            }finally {
                System.out.println("执行第" + i + "次");
            }
        }
    }
}
