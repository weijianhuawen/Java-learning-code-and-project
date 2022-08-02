import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main6_3 {
    public static Set<Integer> getBadmintonList(int seed){
        Set<Integer> set = new TreeSet<Integer>();
        Random rd = new Random(seed);
        while(set.size()<300) {
            set.add(rd.nextInt(1000)+1);
        }
        return set;
    }

    public static Set<Integer> getBasketballList(int seed){
        Set<Integer> set = new TreeSet<Integer>();
        Random rd = new Random(seed);
        while(set.size()<400) {
            set.add(rd.nextInt(1000)+1);
        }
        return set;
    }

    /**
     * 一个班级有学生Student[1,1000]，选修Badminton的有300人，选修Basketball的有400人，请找出：
     *
     * 所有有参加选修的人
     *
     * 既选修了Badminton又选修了Basketball的人
     *
     * 两门课程都没有选修的人
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int seed1 = sc.nextInt();
        int seed2 = sc.nextInt();

        Set<Integer> set1 = getBadmintonList(seed1);
        Set<Integer> set2 = getBasketballList(seed2);

        System.out.println(set1);
        System.out.println(set2);

        Set<Integer> set3 = new TreeSet<>(set1);
        set3.addAll(set2);

        System.out.println(set3.size());
        System.out.println(set3);

        Set<Integer> set4 = new TreeSet<>();
        Set<Integer> set5 = new TreeSet<>();

        for (int i = 1; i <= 1000; i++) {
            if (set1.contains(i) && set2.contains(i)) {
                set4.add(i);
            }
            if (!set1.contains(i) && !set2.contains(i)) {
                set5.add(i);
            }
        }
        System.out.println(set4.size());
        System.out.println(set4);
        System.out.println(set5.size());
        System.out.println(set5);
    }
}
