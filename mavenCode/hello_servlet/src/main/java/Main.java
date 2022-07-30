public class Main {
    public static void main(String[] args) {
        String s;
    }
}
//class Tomcat {
//    // 用来存储所有的 Servlet 对象
//    private List<Servlet> instanceList = new ArrayList<>();
//    public void start() {
//        // 根据约定，读取 WEB-INF/web.xml 配置文件;
//        // 并解析被 @WebServlet 注解修饰的类
//
//        // 假定这个数组里就包含了我们解析到的所有被 @WebServlet 注解修饰的类.
//        Class<Servlet>[] allServletClasses = ...;
//
//        // 这里要做的的是实例化出所有的 Servlet 对象出来;
//        for (Class<Servlet> cls : allServletClasses) {
//            // 这里是利用 java 中的反射特性做的
//            // 实际上还得涉及一个类的加载问题，因为我们的类字节码文件，是按照约定的
//            // 方式（全部在 WEB-INF/classes 文件夹下）存放的，所以 tomcat 内部是
//            // 实现了一个自定义的类加载器(ClassLoader)用来负责这部分工作。
//
//            Servlet ins = cls.newInstance();
//            instanceList.add(ins);
//        }
//
//        // 调用每个 Servlet 对象的 init() 方法，这个方法在对象的生命中只会被调用这一次;
//        for (Servlet ins : instanceList) {
//            ins.init();
//        }
//
//        // 利用我们之前学过的知识，启动一个 HTTP 服务器
//        // 并用线程池的方式分别处理每一个 Request
//        ServerSocket serverSocket = new ServerSocket(8080);
//        // 实际上 tomcat 不是用的固定线程池，这里只是为了说明情况
//        ExecuteService pool = Executors.newFixedThreadPool(100);
//
//        while (true) {
//            Socket socket = ServerSocket.accept();
//            // 每个请求都是用一个线程独立支持，这里体现了我们 Servlet 是运行在多线程环境下的
//            pool.execute(new Runnable() {
//                doHttpRequest(socket);
//            });
//        }
//        // 调用每个 Servlet 对象的 destroy() 方法，这个方法在对象的生命中只会被调用这一次;
//        for (Servlet ins : instanceList) {
//            ins.destroy();
//        }
//    }
//
//    public static void main(String[] args) {
//        new Tomcat().start();
//    }
//}