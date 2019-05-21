package algorithm.dp;

/**
 * 44.通配符匹配
 */
public class IsMatch {
    // dp
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || (i > 0 && dp[i - 1][j]);
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1));
                }
            }
        }
        return dp[sLen][pLen];
    }
    // double point
    public boolean isMatch1(String s, String p) {
        int sLen = s.length(), pLen = p.length(), i = 0, j = 0, start = -1, match = 0;
        while (i < sLen) {
            if (j < pLen && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else if (j < pLen && p.charAt(j) == '*') {
                start = j;
                match = i;
                j++;
            } else if (start != -1) {
                j = start + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }
        while (j < pLen) {
            if (p.charAt(j) != '*') return false;
            j++;
        }
        return true;
    }
}
