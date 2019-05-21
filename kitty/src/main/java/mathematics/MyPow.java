package mathematics;

import org.junit.Test;

public class MyPow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 == 1) {
                res = x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
    @Test
    public void test() {
        myPow(2, 100);
    }
}
