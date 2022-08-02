
import java.util.Scanner;

public class Main7_5 {
    /**
     * 体重是反映和衡量一个人健康状况的重要标志之一，过胖和过瘦都不利于健康，BMI（身体质量指数）计算方法：体重（以千克为单位）除以身高（以米为单位）的平方。中国成人正常的BMI应在18.5-24之间，如果小于18.5为体重不足，如果大于等于24为超重，大于等于28为肥胖。请编写程序，测算身体状态。
     *
     * @param args 7-5
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        double height = sc.nextDouble();

        if (weight  > 727.0|| height > 2.72 || weight <= 0 || height <= 0) {
            System.out.println("input out of range");
            return;
        }

        double bmi = weight / (height * height);
        if (bmi < 18.5) System.out.println("thin");
        else if (bmi < 24) System.out.println("fit");//
        else if (bmi < 28) System.out.println("overweight");//
        else System.out.println("fat");
    }
}
