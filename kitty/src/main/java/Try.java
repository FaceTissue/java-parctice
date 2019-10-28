import bean.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    /**
     * m * n
     * m + n
     * 0
     * @param matrix
     */
    public void setZeros(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    Arrays.fill(res[i], 1);
                    for (int k = 0; k < m; k++) res[k][j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 1) res[i][j] = 0;
                else res[i][j] = matrix[i][j];
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void setZerosTest() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        setZeros(matrix);
        int[][] matrix1 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 5, 1, 5}};
        setZeros(matrix1);
    }

    public void setZeros1(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeros2(int[][] matrix) {
        boolean isCol = false;
        int r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) isCol = true;
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 1; j < c; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isCol) {
            for (int i = 1; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if (r == 0) return false;
        int c = matrix[0].length;
        if (c == 0) return false;
        if (target < matrix[0][0] || target > matrix[r - 1][c - 1]) return false;
        int min = 0, max = r * c - 1, mid, ele;
        while (min <= max) {
            mid = (min + max) / 2;
            ele = matrix[mid / c][mid % c];
            if (target == ele) return true;
            else if (target < ele) max = mid - 1;
            else min = mid + 1;
        }
        return false;
    }
    @Test
    public void searchMatrixTest() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 13, 15},
                {20, 21, 24, 33} };
        System.out.println(searchMatrix(matrix, 12));
        int[][] matrix1 = {{}};
        System.out.println(searchMatrix(matrix1, 1));
    }

    public void sortColors(int[] nums) {
        int n = nums.length, leftIdx = 0, rightIdx = n - 1;
        while (leftIdx < n && nums[leftIdx] == 0) leftIdx++;
        while (rightIdx >= 0 && nums[rightIdx] == 2) rightIdx--;
        for (int i = leftIdx; i <= rightIdx; i++) {
            int temp;
            if (nums[i] == 2) {
                temp = nums[i];
                nums[i--] = nums[rightIdx];
                nums[rightIdx--] = temp;
            } else if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[leftIdx];
                nums[leftIdx++] = temp;
            }
        }
    }
    @Test
    public void sortColorsTest() {
        int[] colors = {2, 0, 2, 1, 1, 0};
        sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }
}
