import java.util.*;

public class Main6_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int seed = sc.nextInt();
        Random random = new Random(seed);

        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(random.nextInt(10) + 1);
            num--;
        }
        System.out.println(list);
        Iterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (n > 5) {
                it.remove();
            } else {
                System.out.println(n);
            }
        }
    }
}
