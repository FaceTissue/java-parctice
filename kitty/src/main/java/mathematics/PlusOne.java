package mathematics;

import org.junit.Test;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits[0] == 0) return new int[]{1};
        int n = digits.length, carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) digits[i] = 0;
            else {
                digits[i]++;
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            int[] tmp = new int[digits.length + 1];
            System.arraycopy(digits, 0, tmp, 1, digits.length);
            tmp[0] = 1;
            digits = tmp;
        }

        return digits;
    }
    @Test
    public void plusOneTest() {
        System.out.println(Arrays.toString(plusOne1(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne1(new int[]{9, 9, 9})));
    }

    // 数学解题
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
