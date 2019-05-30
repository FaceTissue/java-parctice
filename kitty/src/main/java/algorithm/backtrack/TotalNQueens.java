package algorithm.backtrack;

import org.junit.Test;

/**
 * 52.N皇后Ⅱ
 */
public class TotalNQueens {
    private int res = 0;
    public int totalNQueens(int n) {
        bt(n, 0, 0, 0, 0);
        return res;
    }
    private void bt(int n, int row, int col, int ld, int rd) {
        if (row >= n) {
            res++;
            return;
        }
        int bits = ~(col | ld | rd) & ((1 << n) - 1);
        while (bits > 0) {
            int pick = bits & -bits;
            bt(n, row + 1, col | pick, (ld | pick) << 1, (rd | pick) >> 1);
            bits &= bits - 1;
        }
    }

    @Test
    public void totalNQueensTest() {
        System.out.println(totalNQueens(5));
    }
}
