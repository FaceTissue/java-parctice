package algorithm.bt;

import org.junit.Test;

import java.util.Arrays;

public class SolvePluszle {
    int[][] board;
    int n;
    boolean[][] ans;
    int[] rows, colums;
    boolean solved = false;
    private void solvePluszle(int[][] board) {
        this.board = board;
        this.n = board.length - 1;
        this.ans = new boolean[n][n];
        this.rows = new int[n];
        this.colums = new int[n];
        bt(0, 0);
    }
    private void bt(int row, int col) {
        for (int i = col; i < n; i++) {
            if (couldSelect(row, i)) {
                selectNumber(row, i);
                selectNextNumber(row, i);
                if (!solved) removeNumber(row, i);
            }
        }
    }
    private void selectNumber(int row, int col) {
        ans[row][col] = true;
        int num = board[row][col];
        rows[row] += num;
        colums[col] += num;
    }
    private void removeNumber(int row, int col) {
        ans[row][col] = false;
        int num = board[row][col];
        rows[row] -= num;
        colums[col] -= num;
    }
    private void selectNextNumber(int row, int col) {
        if (isSolved()) {
            solved = true;
        }
        else {
            if (rows[row] == board[row][n]) bt(row + 1, 0);
            else if (col < n - 1) bt(row, col + 1);
        }
    }
    private boolean couldSelect(int row, int col) {
        int num = board[row][col];
        boolean r = rows[row] + num <= board[row][n];
        boolean c = row == n - 1 ? colums[col] + num == board[n][col] : colums[col] + num <= board[n][col];
        return r && c;
    }
    private boolean isSolved() {
        for (int i = n - 1; i >= 0; i--) {
            if (!(rows[i] == board[i][n] && colums[i] == board[n][i])) return false;
        }
        return true;
    }

    @Test
    public void test() {
        int[][] pluszle16 = new int[][] {
                {4, 4, 8, 2, 4, 8, 3, 3, 21},
                {5, 8, 8, 4, 2, 1, 9, 8, 26},
                {7, 7, 4, 2, 6, 5, 9, 9, 38},
                {8, 7, 6, 6, 5, 3, 9, 2, 21},
                {8, 2, 3, 8, 9, 7, 8, 8, 37},
                {9, 9, 1, 8, 9, 8, 2, 6, 25},
                {5, 2, 3, 5, 1, 8, 8, 5, 14},
                {1, 5, 5, 7, 4, 5, 4, 7, 12},
                {26, 37, 30, 20, 20, 14, 24, 23}
        };
        int[][] pluszle26 = new int[][] {
                {4, 9, 7, 2, 1, 7, 9, 7, 14},
                {1, 2, 7, 7, 8, 5, 4, 3, 25},
                {3, 9, 8, 8, 6, 3, 8, 5, 19},
                {3, 8, 2, 1, 9, 3, 2, 5, 9},
                {7, 8, 5, 5, 8, 3, 7, 8, 12},
                {8, 3, 6, 7, 6, 3, 3, 1, 20},
                {9, 5, 3, 2, 3, 3, 1, 7, 20},
                {3, 6, 1, 3, 1, 1, 6, 2, 3},
                {17, 10, 27, 15, 16, 4, 25, 8}
        };
        solvePluszle(pluszle26);
        for (boolean[] b : ans) {
            System.out.println(Arrays.toString(b));
        }
    }
}
