package methodThinking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 54.螺旋矩阵
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        spiralOrderRecur(res, matrix, 0);
        return res;
    }
    private void spiralOrderRecur(List<Integer> res, int[][] matrix, int pos) {
        int m = matrix.length, n = matrix[0].length;
        for (int col = pos; col < n - pos; col++) res.add(matrix[pos][col]);
        for (int row = pos + 1; row < m - pos; row++) res.add(matrix[row][n - pos - 1]);
        if (m - pos - 1 != pos) {
            for (int col = n - pos - 2; col >= pos; col--) res.add(matrix[m - pos - 1][col]);
        }
        if (pos != n - pos - 1) {
            for (int row = m - pos - 2; row > pos; row--) res.add(matrix[row][pos]);
        }
        int visited = (pos + 1) * 2;
        if (m > visited && n > visited) spiralOrderRecur(res, matrix, pos + 1);
    }

    @Test
    public void spiralOrderTest() {
        System.out.println(spiralOrder(new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
    }

    // official 模拟
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
}
