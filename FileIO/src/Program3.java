import java.io.*;
import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1. 获取信息
        System.out.println("请输入源文件路径：");
        String src = sc.nextLine();
        System.out.println("请输入目标文件路径：");
        String goal = sc.nextLine();
        File srcFile = new File(src);
        if (!srcFile.isFile()) {
            System.out.println("输入的源文件路径非法！");
            return;
        }
        //2. 拷贝文件
        try (InputStream inputStream = new FileInputStream(srcFile)) {
            try (OutputStream outputStream = new FileOutputStream(goal)){
                while (true) {
                    byte[] bytes = new byte[1024];
                    int len = inputStream.read(bytes);
                    if (len == -1) {
                        break;
                    }
                    outputStream.write(bytes, 0, len);
                }
                System.out.println("拷贝成功！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
