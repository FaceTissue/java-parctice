package mathematics;

import org.junit.Test;

public class MySqrt {
    // 二分法定位
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int iMin = 1, iMax = x / 2;
        while (iMin <= iMax) {
            int mid = (iMin + iMax) / 2;
            if (mid * mid < x) iMin = mid + 1;
            else if (mid * mid > x) iMax = mid - 1;
            else return mid;
        }
        return iMin * iMin > x ? iMin - 1 : iMin;
    }

    // 牛顿法
    public int mySqrt1(int x) {
        long r = x;
        while (r * r > x) r = (r + x / r) / 2;
        return (int) r;
    }

    @Test
    public void mySqrtTest() {
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(15));
        System.out.println(mySqrt(16));
    }
}
