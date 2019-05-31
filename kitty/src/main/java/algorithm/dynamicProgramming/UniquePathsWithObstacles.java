package algorithm.dynamicProgramming;

import org.junit.Test;

public class UniquePathsWithObstacles {
    // my solution
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = i > 0 && j > 0 ? dp[i - 1][j] + dp[i][j - 1] : (i > 0 ? dp[i - 1][j] : (j > 0 ? dp[i][j - 1] : 1));
            }
        }
        return dp[n - 1][m - 1];
    }

    // official space complex O(1)
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1 ? 1 : 0);
        }
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1 ? 1 : 0);
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 0 ? obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1] : 0;
            }
        }
        return obstacleGrid[R - 1][C - 1];
    }

    @Test
    public void obstacleTest() {
        System.out.println(uniquePathsWithObstacles(new int[][] {
                {1, 0},
                {0, 1},
                {0, 0}
        }));
    }
}
