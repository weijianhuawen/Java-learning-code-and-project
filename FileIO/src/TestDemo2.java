import java.io.File;
import java.io.IOException;

public class TestDemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("./creatFile.txt");
        //文件未创建的情况下创建新文件
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建文件成功！");
        }
        //创建一个目录（文件夹）
        file = new File("./creat");
        file.mkdir();
        System.out.println("创建文件夹成功");
        //创建多个目录
        file = new File("./creat1/creat2/creat3");
        file.mkdirs();
        System.out.println("创建多个文件夹成功！");
    }
}
