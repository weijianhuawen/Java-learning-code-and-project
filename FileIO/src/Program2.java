import java.io.*;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        //1. 获取信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入扫描的文件夹：");
        String scanFile = sc.nextLine();
        System.out.println("请输入需要查找的内容：");
        String words = sc.nextLine();
        //2. 如果不是文件夹，输入有误
        File file = new File(scanFile);
        if (!file.isDirectory()) {
            System.out.println("输入的路径非法！");
            return;
        }

        //3. 扫描路径
        scanDire(file, words);
    }
    private static void scanDire(File root, String words) {
        //1.获取当前文件夹所有文件
        File[] files = root.listFiles();
        if (files == null) {
            //目录为空直接返回
            return;
        }
        // 2. 遍历文件
        for (File f : files) {
            if (f.isFile()) {
                //如果文件包含目标内容则打印信息
                if (containsWords(f, words)) {
                    try {
                        System.out.println(f.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (f.isDirectory()) {
                //继续遍历
                scanDire(f, words);
            }
        }
    }
    private static boolean containsWords(File f, String words) {
        StringBuilder stringBuilder = new StringBuilder();
        try(Reader reader = new FileReader(f)) {
            while (true) {
                char[] chars = new char[1024];
                int len = reader.read(chars);
                if (len == -1) {
                    break;
                }
                stringBuilder.append(chars, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.indexOf(words) != -1;
    }
}
