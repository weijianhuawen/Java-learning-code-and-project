import java.util.Scanner;

public class Main7_12 {
    //7-12 学号识别 (10 分)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] majors = {"材料学院", "机械学院", "外语学院" , "软件学院"};
        String str = sc.nextLine();
        String majorId = str.substring(2, 4);
        if (str.length() != 8) {
            System.out.println("Wrong Format");
            return;
        }
        if (!majorId.equals("01") && !majorId.equals("02") && !majorId.equals("03") &&  !majorId.equals("20")) {
            System.out.println("Wrong Format");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                System.out.println("Wrong Format");
                return;
            }
        }
        System.out.println("入学年份：20" + str.substring(0, 2) + "年");


        if (majorId.equals("01")) System.out.println("学院：" + majors[0]);
        else if (majorId.equals("02"))  System.out.println("学院：" + majors[1]);
        else if (majorId.equals("03"))  System.out.println("学院：" + majors[2]);
        else System.out.println("学院：" + majors[3]);

        System.out.println("班级：" + str.substring(4, 6));
        System.out.println("学号：" + str.substring(6, 8));
    }
}
