package mathematics;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8.字符串转换整数
 */
public class MyAtoi {
    @Test
    public void myAtoi() {
        Pattern pattern = Pattern.compile("^( *)([+-]?\\d*)");
        Matcher matcher = pattern.matcher("      +100000aaaaaa");
        if (matcher.find()) {
            String number = matcher.group(2);
            System.out.println(number);
            try {
                System.out.println(Integer.parseInt(number));
            } catch (Exception e) {
                System.out.println(0);
            }
        } else {
            System.out.println(0);
        }
    }

    @Test
    public void myAtoi1() {
//        String str = "       -1000hello   ";
        String str = "42";
        if ("".equals(str)) System.out.println(0);
        char[] chars = str.trim().toCharArray();
        if (!(chars[0] == '-' || chars[0] == '+' || Character.isDigit(chars[0])))
            System.out.println(0);
        StringBuilder sb = new StringBuilder(chars[0] + "");
        int len = 1;
        while (len < chars.length && chars[len] >= '0' && chars[len] <= '9') sb.append(chars[len++]);
        try {
            double v = Double.parseDouble(sb.toString());
            if (v > Integer.MAX_VALUE) System.out.println(Integer.MAX_VALUE);
            if (v < Integer.MIN_VALUE) System.out.println(Integer.MIN_VALUE);
        } catch (Exception e) {
            System.out.println(0);
        }
    }

    public int myAtoi2(String str) {
        String strAfterTrim = str.trim();
        if ("".equals(strAfterTrim)) return 0;
        int ret = 0, st = 1, n = strAfterTrim.length();
        char c = strAfterTrim.charAt(0);
        if (c == '-') {
            while (st < n && strAfterTrim.charAt(st) >= '0' && strAfterTrim.charAt(st) <= '9') {
                int pop = -(strAfterTrim.charAt(st++) - '0');
                if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < -8)) return Integer.MIN_VALUE;
                ret = ret * 10 + pop;
            }
        } else if (c == '+' || (c >= '0' && c <= '9')) {
            if (c != '+') ret = c - '0';
            while (st < n && strAfterTrim.charAt(st) >= '0' && strAfterTrim.charAt(st) <= '9') {
                int pop = strAfterTrim.charAt(st++) - '0';
                if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > 7)) return Integer.MAX_VALUE;
                ret = ret * 10 + pop;
            }
        }
        return ret;
    }

    @Test
    public void myTrim() {
        String str = "    Hello ";
        char[] chars = str.toCharArray();
        int length = chars.length;
        int st = 0;
        while (st < length && chars[st] <= ' ') st++;
        while (st < length && chars[length - 1] <= ' ') length--;
        String ret = (st > 0 || length < chars.length) ? str.substring(st, length) : str;
        System.out.println(ret);
    }
}
