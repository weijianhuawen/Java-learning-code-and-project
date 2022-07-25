import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestDemo7 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("D:\\未见花闻\\项目\\文件IOFile类演示\\creat.txt")) {
            writer.write("未见花闻");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
