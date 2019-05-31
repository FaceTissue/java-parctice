package algorithm.dynamicProgramming;

import org.junit.Test;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        for (int i = 1; i < R; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < C; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[R - 1][C - 1];
    }
    @Test
    public void minPathSumTest() {
        System.out.println(minPathSum(new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
}
