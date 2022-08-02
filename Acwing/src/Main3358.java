import java.util.Scanner;

public class Main3358 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String alphabet = sc.nextLine();
        String sing = sc.nextLine();

        char[] alp = alphabet.toCharArray();
        char[] listen = sing.toCharArray();

        //奶牛只能按特定顺序听到字母，所以每次听歌只能听到有序字母集，所以模拟遍历歌曲，在特定字母表找即可
        int ans = 0;
        int i = 0;
        while (i < listen.length){
            for (int j = 0; j < alp.length; j++) {
                if (listen[i] == alp[j]) {
                     i++;
                     if (i >= listen.length) break;
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
}
