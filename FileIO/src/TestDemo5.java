import java.io.*;

public class TestDemo5 {
    public static void main(String[] args) {
        try {
            //按照字节为单位读取
            InputStream inputStream = new FileInputStream("D:/未见花闻/项目/文件IOFile类演示/测试.txt");
            //按照以字符为单位读取
            Reader reader = new FileReader("D:/未见花闻/项目/文件IOFile类演示/测试.txt");

            while (true) {
                byte[] bytes = new byte[1024];
                int len = inputStream.read(bytes);
                if (len == -1) break;
                //字节
                for (int i = 0; i < len; i++) {
                    System.out.print(bytes[i] + "  ");
                }
            }
            //关闭文件
            inputStream.close();
            System.out.println();
            while (true) {
                char[] chars = new char[1024];
                int len = reader.read(chars);
                if (len == -1) break;
                //字符
                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i] + "  ");
                }
            }
            //关闭文件
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}