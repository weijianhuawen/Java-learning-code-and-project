package main.wei.jian.hua.wen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        String str = "end";
        String input = sc.nextLine();
        while (!str.equals(input)) {
            if (!list.contains(input)) list.add(input);
            input = sc.nextLine();
        }
        System.out.println(list);
        int index = sc.nextInt();
        sc.nextLine();
        input = sc.nextLine();
        list.add(index, input);
        index = sc.nextInt();
        sc.nextLine();
        list.remove(index);
        System.out.println(list);
        input = sc.nextLine();
        int k = list.indexOf(input);
        System.out.println("k=" + k);
        input = sc.nextLine();
        if (k >= 0) list.set(k, input);
        else list.add(input);
        System.out.println(list);
    }
}
