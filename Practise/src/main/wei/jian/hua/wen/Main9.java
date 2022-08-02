package main.wei.jian.hua.wen;
import java.lang.reflect.*;
import java.util.Scanner;
import java.util.concurrent.Callable;

class Calculator{
    final static double PI  = 3.14;
    final static double E = 2.71828;//使用这些常量来进行计算


    public static double add(double numb1,double numb2){
        return numb1 + numb2;
    }//两个数相加
    public static double substract(double numb1,double numb2) {
        return numb1 - numb2;
    }//两个数相减
    public static double multiply(double numb1,double numb2) {
        return numb1 * numb2;
    }//两个数相乘
    public static double divide(double numb1,double numb2) {
        return numb1 / numb2;
    }//两个数相除
    public static double perimeter(double numb) {
        return 2 * Calculator.PI * numb;
    }//给定半径求周长
    public static double area(double numb) {
        return Calculator.PI * numb * numb;
    }//给定半径求面积
    public static double log(double numb) {
       return Math.log10(numb) / Math.log10(Calculator.E);
    }//给定一个数X（>0）
}
public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        double y = sc.nextDouble();

        double r = sc.nextDouble();
        double z = sc.nextDouble();


        System.out.println(Calculator.add(x, y));
        System.out.println(Calculator.substract(x, y));
        System.out.println(Calculator.multiply(x, y));
        System.out.println(Calculator.divide(x, y));

        System.out.println(Calculator.perimeter(r));
        System.out.println(Calculator.area(r));
        System.out.println(Calculator.log(z));

        System.out.println("检验程序的输出");
        Class<?> clazz = Calculator.class;
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        boolean flag=true;
        System.out.println(clazz);
        for (Field field : fields) {
            if(Modifier.isFinal(field.getModifiers())&&Modifier.isStatic(field.getModifiers())!=true)
                flag=false;
        }
        for (Method method : methods) {
            if(Modifier.isStatic(method.getModifiers())!=true)
                flag=false;
        }
        System.out.println(flag);

    }
}
