import java.io.IOException;
import java.util.HashMap;

public class TcpDictServer extends TcpEchoServer{
    private final HashMap<String, String> dict = new HashMap<>();
    public TcpDictServer(int port) throws IOException {
        super(port);

        //词库
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("bird", "小鸟");
        dict.put("apple", "苹果");
        dict.put("banana", "香蕉");
        dict.put("strawberry", "草莓");
        dict.put("watermelon", "西瓜");
    }

    @Override
    public String process(String data) {
        return dict.getOrDefault(data, "词库为找到该单词！");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9092);
        server.start();
    }
}
