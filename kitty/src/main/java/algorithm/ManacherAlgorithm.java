package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 5.最长回文子串
 */
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


    @Test
    public void test() {
        String cbbd = manacherAlgorithm("cbbd");
        System.out.println(cbbd);
        System.out.println(-100 % 10);
        System.out.println(524288 / 10);
        System.out.println("hello".substring(0, 0));
    }
}
