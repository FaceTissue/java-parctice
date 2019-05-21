package algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * leetCode 10.正则表达式匹配
 */
public class MyRegex {
    public boolean isMatch(String s, String p) {
        if ("".equals(p) && !"".equals(s)) return false;
        int n = p.length(), m = n;
        String[] grp = new String[n];
        for (int i = 0, j = 0; i < n;) {
            if (i + 1 < n && p.charAt(i + 1) == '*') {
                grp[j++] = p.substring(i, i + 2);
                i += 2;
                m--;
            } else {
                grp[j++] = p.charAt(i) + "";
                i++;
            }
        }
        grp = Arrays.copyOf(grp, m);
        System.out.println(Arrays.toString(grp));
        int idx = 0, endPoint = 0;
        for (int i = 0; i < grp.length; i++) {
            String reg = grp[i];
            if (!reg.endsWith("*")) {
                if (idx >= s.length()) return false;
                if (".".equals(reg)) {
                    idx++;
                    endPoint = i + 1;
                }
                else {
                    while (idx < s.length() && !String.valueOf(s.charAt(idx)).equals(reg)) {
                        boolean flag = true;
                        for (int j = i - 1; j >= endPoint; j--) {
                            if (grp[j].charAt(0) == s.charAt(idx) || grp[j].charAt(0) == '.') {
                                idx++;
                                endPoint = j;
                                flag = false;
                                break;
                            }
                        }
                        if (flag) return false;
                    }
                    if (idx == s.length()) return false;
                    idx++;
                    endPoint = i + 1;
                }
            }
        }
        while (idx < s.length() && endPoint < m) {
            boolean flag = true;
            for (int i = endPoint; i < m; i++) {
                if (grp[i].charAt(0) == s.charAt(idx) || grp[i].charAt(0) == '.') {
                    endPoint = i;
                    idx++;
                    flag = false;
                    break;
                }
            }
            if (flag) return false;
        }
//        while (idx < s.length() && grp[m - 1].endsWith("*") &&
//                (s.charAt(idx) == grp[m - 1].charAt(0) || '.' == grp[m - 1].charAt(0))) idx++;
        return idx == s.length();
    }

    public boolean isMatch1(String s, String p) {
        int n = p.length(), m = n;
        String[] grp = new String[n];
        for (int i = 0, j = 0; i < n;) {
            if (i + 1 < n && p.charAt(i + 1) == '*') {
                grp[j++] = p.substring(i, i + 2);
                i += 2;
                m--;
            } else {
                grp[j++] = p.charAt(i) + "";
                i++;
            }
        }
        grp = Arrays.copyOf(grp, m);
        int idx = 0, endPoint = 0;
        while (idx < s.length() && endPoint < m) {
            boolean flag = true;
            for (int i = endPoint; i < m; i++) {
                if (grp[i].charAt(0) == s.charAt(idx) || grp[i].charAt(0) == '.') {
                    endPoint = grp[i].endsWith("*") ? i : i + 1;
                    idx++;
                    flag = false;
                    break;
                }
            }
            if (flag) return false;
        }
        return idx == s.length();
    }

    public boolean isMatch3(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1));
                }
            }
        }
        for (boolean[] b : dp) System.out.println(Arrays.toString(b));
        return dp[sLen][pLen];
    }

    @Test
    public void test() {
        System.out.println(isMatch3("ab", ".*c"));
        System.out.println(isMatch3("aaa", "aa"));
    }
}
