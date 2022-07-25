import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestDemo4 {
    public static void main(String[] args) throws IOException {
        File file = new File("./");
        //获取当前路径目录下所有文件名
        System.out.println(Arrays.toString(file.list()));

        File f = new File("./aaa/bbb/ccc/ddd");
        File f2 = new File("./aaa");
        File tmp = new File("./zzz");
        //按照f对象创建目录
        f.mkdirs();
        //获取当前路径目录下所有文件名
        System.out.println(Arrays.toString(file.list()));
        //重命名aaa，或者说将zzz覆盖aaa
        System.out.println(f2.renameTo(tmp));
        //获取当前路径目录下所有文件名
        System.out.println(Arrays.toString(file.list()));
        System.out.println(f2.getName());
        System.out.println(tmp.getName());
    }
}
