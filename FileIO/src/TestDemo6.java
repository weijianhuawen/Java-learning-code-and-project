import java.io.*;

public class TestDemo6 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("D:/未见花闻/项目/文件IOFile类演示/测试.txt")) {
            while (true) {
                byte[] bytes = new byte[1024];
                int len = inputStream.read(bytes);
                if (len == -1) break;
                //字节
                for (int i = 0; i < len; i++) {
                    System.out.print(bytes[i] + "  ");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        try (Reader reader = new FileReader("D:/未见花闻/项目/文件IOFile类演示/测试.txt");) {
            while (true) {
                char[] chars = new char[1024];
                int len = reader.read(chars);
                if (len == -1) break;
                //字符
                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i] + "  ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
