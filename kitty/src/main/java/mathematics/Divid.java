package mathematics;

public class Divid {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException();
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = (dividend ^ divisor) < 0;
        long d = Math.abs((long) dividend);
        long t = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((d >> i) >= t) {
                result += 1 << i;
                d -= t << i;
            }
        }
        return negative ? -result : result;
    }
}
