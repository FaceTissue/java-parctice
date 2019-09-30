import bean.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/***************************************************************************
 * @className: Try
 * @date     : 2019/9/29 16:36
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class Try {
    /**
     * 确定阶段
     * 状态及状态变量
     * 状态转移方程
     * 边界条件
     *
     * 最优子结构、重叠子问题、无后效性
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + 1;
        for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int temp = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                dp[i][j] = word1.charAt(i) == word2.charAt(j) ? temp : temp + 1;
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void minDistanceTest() {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }

    public int longestSubstring(String s, int k) {
        int res = 0, i = 0, n = s.length();
        while (i + k <= n) {
            int m[] = new int[26], mark = 0, maxIdx = i;
            for (int j = i; j < n; j++) {
                int p = s.charAt(j) - 'a';
                ++m[p];
                if (m[p] < k) mark |= 1 << p;
                else mark &= ~(1 << p);
                if (mark == 0) {
                    res = Math.max(res, j - i + 1);
                    maxIdx = j;
                }
            }
            i = maxIdx + 1;
        }
        return res;
    }
}
