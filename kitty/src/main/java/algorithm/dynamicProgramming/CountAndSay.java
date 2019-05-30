package algorithm.dynamicProgramming;

/**
 * 38.报数
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String[] dp = new String[n + 1];
        dp[1] = "1";
        for (int i = 2; i <= n; i++) {
            String prev = dp[i - 1];
            int l = 0, r = 0;
            StringBuilder sb = new StringBuilder();
            while (l < prev.length()) {
                while (++r < prev.length() && prev.charAt(r) == prev.charAt(l));
                sb.append(r - l).append(prev.charAt(l));
                l = r;
            }
            dp[i] = sb.toString();
        }
        return dp[n];
    }
}
