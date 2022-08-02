import java.util.List;
import java.util.Scanner;

public class Main4318 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        if (str.contains("U") && str.contains("D") || str.contains("L") && str.contains("R")) System.out.println("NO");
        else System.out.println("YES");

    }
}
