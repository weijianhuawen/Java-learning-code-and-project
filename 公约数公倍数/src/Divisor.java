public class Divisor {
    public int maxDivisor(int a, int b) {
        int m = b;
        while (m != 0) {
            m = a % b;
            a = b;
            b = m;
        }
        return a;
    }

    public int minMultiple (int a, int b) {
        int div = maxDivisor(a, b);
        return a * b / div;
    }
}
