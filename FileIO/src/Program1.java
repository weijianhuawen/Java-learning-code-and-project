import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1. 获取信息
        System.out.println("请输入需要扫描的文件夹：");
        String scanPath = sc.nextLine();
        System.out.println("请输入需要删除的文件名：");
        String fileName = sc.nextLine();

        File file = new File(scanPath);
        if (!file.isDirectory()) {
            System.out.println("输入的文件路径有误！");
            return;
        }
        //2. 遍历目录
        scanDire(file, fileName);
    }
    private static void scanDire(File rootDire, String fileName) {
        //1.获取当前文件夹下面的的文件
        File[] files = rootDire.listFiles();
        if (files == null) {
            //空目录，直接返回
            return;
        }
        //2.遍历当前文件夹所有文件，如果是普通文件就询问删除，否则继续遍历子文件夹
        for (File x : files) {
            if (x.isFile()) {
                if (x.getName().contains(fileName)) {
                    //删除文件
                    deleteFile(x);
                }
            } else if (x.isDirectory()){
                //继续遍历
                scanDire(x, fileName);
            }
        }
    }
    private static void deleteFile(File file) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("请确认是否需要删除文件(yes/no)：" + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = sc.nextLine();
        if (str.equalsIgnoreCase("yes")) {
            boolean ret =file.delete();
            if (ret) System.out.println("已经成功删除！");
            else System.out.println("删除失败！");
        } else {
            System.out.println("已经取消删除！");
        }
    }
}
