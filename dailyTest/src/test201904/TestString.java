package test201904;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestString {
    public static void main(String[] args) {
//        System.out.println(convert("PAYPALISHIRING", 4));
//        System.out.println(convert1("PAYPALISHIRING", 4));
//        System.out.println(convert1("A", 100));
        String str = "-012";
        StringBuilder num = new StringBuilder(str);
        num.reverse();
        num.insert(0, "+++");
        System.out.println(num.toString());

        System.out.println(reverse(1534236469));
        System.out.println(reverse1(-10));
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public static String longestPalindrome(String s) {
        String manacherStr = "$#";
        for (int i = 0; i < s.length(); i++) {
            manacherStr = manacherStr + s.charAt(i) + "#";
        }
        int[] radius = new int[manacherStr.length()];
        int mx = 0, id = 0, ansLen = 0, ansCenter = 0;
        for (int i = 1; i < manacherStr.length() - 1; i++) {
            radius[i] = mx > i ? Math.min(radius[2*id-i], mx - i) : 1;
            while (i - radius[i] >= 0 &&
                    i + radius[i] <manacherStr.length() &&
                    manacherStr.charAt(i + radius[i]) == manacherStr.charAt(i - radius[i])) radius[i]++;
            if (radius[i] + i > mx) {
                mx = i + radius[i];
                id = i;
            }
            if (radius[i] > ansLen) {
                ansLen = radius[i];
                ansCenter = i;
            }
        }
        return s.substring((ansCenter - ansLen) / 2, ansLen - 1 + (ansCenter - ansLen) / 2);
    }

    static String convert(String s, int numRows) {
        List<String> a = new ArrayList<>();
        int carry = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            String ans = "";
            for (int j = i; j < s.length(); j += carry) {
                ans += s.charAt(j);
            }
            a.add(ans);
        }
        List<String> b = new ArrayList<>();
        for (int i = numRows; i < carry; i++) {
            String ans = "";
            for (int j = i; j < s.length(); j += carry) {
                ans += s.charAt(j);
            }
            b.add(ans);
        }
        String result = "";
        for (int i = 0; i < a.size(); i++) {
            String str1 = a.get(i);
            String str2 = "";
            int temp = numRows - 2 - i;
            if (temp < b.size() && temp >= 0) {
                str2 = b.get(numRows - 2 - i);
            }
            int length = Math.max(str1.length(), str2.length());
            for (int j = 0; j < length; j++) {
                if (j < str1.length()) result += str1.charAt(j);
                if (j < str2.length()) result += str2.charAt(j);
            }
        }
        return result;
    }

    static String convert1(String s, int numRows) {
        int carry = numRows * 2 - 2;
        if (carry == 0) return s;
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) map.put(i, s.charAt(i));
        String result = "";
        for (int i = 0; i < numRows; i++) {
            int j = carry - i;
            if (j > 0 && j < carry && j != i) {
                for (int p = i, q = j; p < s.length() || q < s.length(); p += carry, q += carry) {
                    if (p < s.length()) result += map.get(p);
                    if (q < s.length()) result += map.get(q);
                }
            } else {
                for (int p = i; p < s.length(); p += carry) {
                    result += map.get(p);
                }
            }
        }
        return result;
    }
    public static int reverse(int x) {
        if (x == 0) return x;
        StringBuilder num = new StringBuilder();
        num.append(Math.abs(x));
        num.reverse();
        if (x < 0) num.insert(0, "-");
        try {
            return Integer.parseInt(num.toString());
        } catch (Exception e) {
            return 0;
        }
    }
    public static int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
