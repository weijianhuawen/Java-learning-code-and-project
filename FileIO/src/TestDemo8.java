import java.io.*;

public class TestDemo8 {
    public static void main(String[] args) {
        try(OutputStream outputStream = new FileOutputStream("D:\\未见花闻\\项目\\文件IOFile类演示\\字节写入.txt")) {
            outputStream.write('c');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
