public class Main3 extends Thread{
    public static void main(String[] args) {
        Main3 m = new Main3();
        m.start();
    }
    public void start() {
        for (int i = 0; i < 10; i++) {
            System.out.println("value=" + i);
        }
    }
}
