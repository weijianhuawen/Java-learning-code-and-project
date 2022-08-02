import java.util.Scanner;

public class Main7_13 {
    public static void main(String[] args) {
        //7-13 群发邮件 (10 分)
        Scanner sc= new Scanner(System.in);

        String str = sc.nextLine();

        String[] message = str.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length; i++) {
            String[] ret = message[i].split("/");
            stringBuilder.append(ret[2]);
            stringBuilder.append(";");
        }
        String ans = stringBuilder.toString();
        System.out.println(ans);
    }
}
