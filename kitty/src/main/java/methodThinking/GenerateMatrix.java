package methodThinking;

import org.junit.Test;

import java.util.Arrays;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int r = 0, c = 0, di = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        boolean[][] visited = new boolean[n][n];
        for (int i = 1; i <= n * n; i++) {
            res[r][c] = i;
            visited[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < n && 0 <= cc && cc < n && !visited[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return res;
    }

    @Test
    public void generateMatrixTest() {
        for (int[] arr : generateMatrix(1)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
