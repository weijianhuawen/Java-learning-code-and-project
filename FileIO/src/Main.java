import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //由于历史原因，Windows最开始用的是\作为分隔符，但是后面后悔了，不好改，所以Windows后来/\作为分隔符都可以，但系统默认的是\
        //使用\作为分隔符需要转义
        //File file = new File("D:\\未见花闻\\项目\\文件IOFile类演示.txt");
        //通过绝对路径字符串创建文件对象，创建文件对象时不会自动创建文件
        File file = new File("D:/未见花闻/项目/文件IOFile类演示/测试.txt");
        //获取当前文件对象的文件名
        System.out.println(file.getName());
        //获取当前文件的绝对路径字符串
        System.out.println(file.getAbsolutePath());
        //获取当前文件的规范化的绝对路径字符串
        System.out.println(file.getCanonicalPath());
        //获取当前文件父目录的路径字符串
        System.out.println(file.getParent());
        //获取当前文件对象构造时所传入的路径字符串
        System.out.println(file.getPath());

        System.out.println("================");

        //通过相对路径字符串创建文件对象
        File file2 = new File("./测试.txt");
        //获取当前文件对象的文件名
        System.out.println(file2.getName());
        //获取当前文件的绝对路径字符串
        System.out.println(file2.getAbsolutePath());
        //获取当前文件的规范化的绝对路径字符串
        System.out.println(file2.getCanonicalPath());
        //获取当前文件父目录的路径字符串
        System.out.println(file2.getParent());
        //获取当前文件对象构造时所传入的路径字符串
        System.out.println(file2.getPath());


        System.out.println("================");

        File file3 = file2.getAbsoluteFile();
        //获取当前文件对象的文件名
        System.out.println(file3.getName());
        //获取当前文件的绝对路径字符串
        System.out.println(file3.getAbsolutePath());
        //获取当前文件的规范化的绝对路径字符串
        System.out.println(file3.getCanonicalPath());
        //获取当前文件父目录的路径字符串
        System.out.println(file3.getParent());
        //获取当前文件对象构造时所传入的路径字符串
        System.out.println(file3.getPath());
    }
}
