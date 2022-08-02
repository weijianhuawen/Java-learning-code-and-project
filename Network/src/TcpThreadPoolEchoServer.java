import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TcpThreadPoolEchoServer {
    //1. 创建socket对象
    private ServerSocket serverSocket;
    public TcpThreadPoolEchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }
    //2. 启动服务器
    public void start() throws IOException {
        System.out.println("服务器准备就绪!");
        //创建线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        while (true) {
            // 3. 接收客户端的“电话"
            Socket clientSocket = serverSocket.accept();

            // 4. 接收 处理 回应数据
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processContain(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    private void processContain(Socket clientSocket) throws IOException {
        System.out.printf("[%s:%d] 服务器正式与客户端建立连接！\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
        try (InputStream inputStream = clientSocket.getInputStream()) {
            try (OutputStream outputStream = clientSocket.getOutputStream()) {
                //接收数据 使用Scanner比InputStream的原生方法read更方便
                Scanner receiveScanner = new Scanner(inputStream);
                while (true) {
                    if (!receiveScanner.hasNext()) {
                        System.out.printf("[%s:%d] 服务器与客户端已经断开连接！\n", clientSocket.getInetAddress().toString(),
                                clientSocket.getPort());
                        break;
                    }
                    String request = receiveScanner.next();
                    //处理数据
                    String response = process(request);
                    //发送数据，为了方便，我们可以使用PrintWriter类将OutputStream类对象包裹起来,就是用来把数据打印到文件里面
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(response);
                    //及时刷新缓冲区
                    printWriter.flush();
                    //输出回应信息
                    System.out.printf("[%s:%d] 收到的请求: %s  回应: %s\n", clientSocket.getInetAddress().toString(),
                            clientSocket.getPort(), request, response);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源 相当于挂断电话
            clientSocket.close();
        }
    }
    public String process(String data) {
        return data;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadPoolEchoServer server = new TcpThreadPoolEchoServer(9091);
        server.start();
    }
}