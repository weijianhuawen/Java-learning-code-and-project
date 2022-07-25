import java.io.File;

public class TestDemo1 {
    public static void main(String[] args) {
        File file = new File("./测试.txt");

        //判断文件是否存在
        System.out.println(file.exists());
        //判断File对象的路径是否是绝对路径
        System.out.println(file.isAbsolute());
        //判断文件是否是文件夹（目录）
        System.out.println(file.isFile());
        //判断文件是否是隐藏文件
        System.out.println(file.isHidden());
        //判断文件是否能够执行/读/写
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
    }
}
