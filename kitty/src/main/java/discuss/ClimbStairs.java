package discuss;

import org.junit.Test;

public class ClimbStairs {
    public int climbStairs1(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs1(i + 1, n) + climbStairs1(i + 2, n);
    }

    public int climbStairs2(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairs2(i + 1, n, memo) + climbStairs2(i + 2, n, memo);
        return memo[i];
    }

    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    @Test
    public void test() {
        System.out.println(climbStairs1(0, 20));
        System.out.println(climbStairs2(0, 20, new int[21]));
        System.out.println(climbStairs3(20));
        System.out.println(climbStairs4(20));
        System.out.println(" ".length());
    }
}
