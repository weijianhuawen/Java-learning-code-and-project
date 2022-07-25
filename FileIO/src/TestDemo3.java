import java.io.File;

public class TestDemo3 {
    public static void main(String[] args) {
        //删除操作
        File file = new File("./测试.txt");
        file.delete();
    }
}
