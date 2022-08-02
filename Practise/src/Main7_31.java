import java.util.Map;
import java.util.Scanner;

public class Main7_31 {

    //将一行数据转换为一个半径数组
    public static double[] getRadius(String line) {
        try {
            if (line.equals("")) throw new NullPointerException("java.lang.NullPointerException");
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        String[] strs = line.split(" ");
        double[] data = new double[strs.length];
        for (int i = 0; i < data.length; i++) {
            try {
                data[i] = Double.valueOf(strs[i]);
            } catch (NumberFormatException e) {
                if (!e.getMessage().equals("empty String")) System.out.println("java.lang.NumberFormatException: "+e.getMessage());
            }
        }
        return data;
    }
    //求半径数组中第五个数据对应的圆形的面积（π的值使用Math类中的PI，平方计算使用Math中的pow()方法）
    public static double getFiveArea(double[] circles) {
        try {
            if (circles.length < 5) throw new ArrayIndexOutOfBoundsException("java.lang.ArrayIndexOutOfBoundsException: 4");
            else if (circles[4] <= 0) throw new RuntimeException("java.lang.RuntimeException");
            return Math.PI * Math.pow(circles[4], 2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    /**
     * 在main方法中定义两个静态方法double[] getRadius(String line)以及double getFiveArea(double[] circles)。分别用于将一行数据转换为一个半径数组以及求半径数组中第五个数据对应的圆形的面积（π的值使用Math类中的PI，平方计算使用Math中的pow()方法）。
     *
     * 首先输入多行数据，遇到"!!!!!"时停止输入，调用getRadius方法将每一行数据转化为半径数组，其中按空格进行数据的分割，其中如果输入的是空行则抛出NullPointerException异常，否则则进行相应的数据转换。若发生异常则输出异常信息(toString()方法)，接着使用getFiveArea()方法得到并输出转换完成后的数组中的第五个数据对应的圆形面积，如果数组长度小于5，则抛出IndexOutOfBoundsException异常，如果数组的第五个数据小于等于0，则抛出RuntimeException异常。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        while (!line.equals("!!!!!")) {
            double[] data = getRadius(line);
            double area = getFiveArea(data);
            System.out.println(area);
            line = sc.nextLine();
        }
    }
}
