package algorithm.dynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

public class UniquePaths {
    // my solution
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = i > 0 && j > 0 ? dp[i - 1][j] + dp[i][j - 1] : 1;
            }
        }
        return dp[n - 1][m - 1];
    }

    // optimize space complex
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    @Test
    public void uniquePathsTest() {
        System.out.println(uniquePaths(7, 3));
    }
}
