public class AvgSwap {
    public static void swap(int[] data) {
        int tmp = data[0];
        data[0] = data[1];
        data[1] = tmp;
    }
    public static double avg(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return 1.0 * sum / data.length;
    }

    public static void main(String[] args) {
        int[] swap = {22, 33};
        int[] avg = {1,2,3,4,5,6,7,8,9,0};
        System.out.println("数据交换前：a = " + swap[0] + ", b = " + swap[1]);
        swap(swap);
        System.out.println("数据交换后：a = " + swap[0] + ", b = " + swap[1]);
        System.out.println("数组平均值为：" + avg(avg));
    }
}
