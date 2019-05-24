package mathematics;

/**
 * 7.整数反转
 */
public class Reverse {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int carry = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && carry > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && carry < -8)) return 0;
            result = result * 10 + carry;
            x = x / 10;
        }
        return result;
    }
}
