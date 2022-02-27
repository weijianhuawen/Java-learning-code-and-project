public class Test8 {
    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 2 == 0) {
            return numberOfSteps(num / 2) + 1;
        } else {
            return numberOfSteps(num - 1) + 1;
        }
    }
    public int func(int x) {
        return numberOfSteps(x);
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        String str = null;
        try {
            System.out.println(str.equals("aaa"));
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个运行时异常！");
        }
    }
}
class Solution {
    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 2 == 0) {
            return numberOfSteps(num / 2) + 1;
        } else {
            return numberOfSteps(num - 1) + 1;
        }
    }
}