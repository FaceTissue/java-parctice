package algorithm.dynamicProgramming;

import org.junit.Test;

/***************************************************************************
 * @className: MinDistance
 * @date     : 2019/9/10 15:06
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class MinDistance {
    // bottom-up dynamic programming
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) dp[0][j] = dp[0][j - 1] + 1;
        for (int i = 1; i <= n; i++) dp[i][0] = dp[i - 1][0] + 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n][m];
    }
    // top-down dynamic programming
    public int minDistance1(String word1, String word2) {
        if ("".equals(word1) || "".equals(word2)) {
            return word1.length() + word2.length();
        }
        if (word1.charAt(0) == word2.charAt(0)) {
            return minDistance1(word1.substring(1), word2.substring(1));
        } else {
            int insert = minDistance1(word1.substring(1), word2) + 1;
            int delete = minDistance1(word1, word2.substring(1)) + 1;
            int alter = minDistance1(word1.substring(1), word2.substring(1)) + 1;
            return Math.min(Math.min(insert, delete), alter);
        }
    }
    // top-down dynamic programming -memory table optimize
    public int minDistance2(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        return dp_optimize(memo, word1, word2);
    }
    public int dp_optimize(int[][] memo, String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (memo[n][m] != 0) {
            return memo[n][m];
        }
        if ("".equals(word1) || "".equals(word2)) {
            memo[n][m] = m + n;
            return memo[n][m];
        }
        if (word1.charAt(0) == word2.charAt(0)) {
            return dp_optimize(memo, word1.substring(1), word2.substring(1));
        } else {
            int insert = dp_optimize(memo, word1.substring(1), word2) + 1;
            int delete = dp_optimize(memo, word1, word2.substring(1)) + 1;
            int alter = dp_optimize(memo, word1.substring(1), word2.substring(1)) + 1;
            int distance = Math.min(Math.min(insert, delete), alter);
            memo[n][m] = distance;
            return distance;
        }
    }
    @Test
    public void minDistanceTest() {
        System.out.println(minDistance("horse", "ros"));

        int distance = 0;

        long start_optimize = System.currentTimeMillis();
        distance = minDistance2("administrator", "cat_dog_pig");
        long end_optimize = System.currentTimeMillis();
        long t2 = end_optimize - start_optimize;
        System.out.println("dp_optimize result:" + distance + ",time:" + t2);

        long start = System.currentTimeMillis();
        distance = minDistance1("administrator", "cat_dog_pig");
        long end = System.currentTimeMillis();
        long t1 = end - start;
        System.out.println("dp result:" + distance + ",time:" + t1);
    }

}
