package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ManacherAlgorithm {
    public String manacherAlgorithm(String s) {
        String t = "$#";
        for (int i = 0; i < s.length(); i++) {
            t += s.charAt(i);
            t += '#';
        }
        char[] chars = t.toCharArray();
        int[] p = new int[chars.length];
        int id = 0, mx = 0, ansLen = 0, ansCenter = 0;
        for (int i = 0; i < chars.length; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i - p[i] >= 0 && i + p[i] < chars.length && chars[i - p[i]] == chars[i + p[i]]) p[i]++;
            if (i + p[i] > mx) {
                id = i;
                mx = i + p[i];
            }
            if (ansLen < p[i]) {
                ansLen = p[i];
                ansCenter = i;
            }
        }
        return s.substring((ansCenter - ansLen) / 2,(ansCenter - ansLen) / 2 + ansLen - 1);
    }

    public String convert(String s, int numRows) {
        if (1 == numRows) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) sbs[i] = new StringBuilder();
        boolean flag = false;
        for (int i = 0, j = 0; i < s.length(); i++) {
            sbs[j].append(s.charAt(i));
            if (j == 0 || j == numRows - 1) flag = !flag;
            j = flag ? j + 1 : j - 1;
        }
        String result = "";
        for (StringBuilder sb : sbs) {
            result += sb.toString();
        }
        return result;
    }

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

    @Test
    public void test() {
        String cbbd = manacherAlgorithm("cbbd");
        System.out.println(cbbd);
        System.out.println(convert("hello", 3));
        System.out.println(-100 % 10);
        System.out.println(reverse(21));
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(524288 / 10);
        System.out.println("hello".substring(0, 0));
    }
}
