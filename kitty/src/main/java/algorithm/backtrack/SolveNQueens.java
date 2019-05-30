package algorithm.backtrack;

import org.junit.Test;

import java.util.*;

/**
 * 51.N皇后
 */
public class SolveNQueens {
    // my solution --!
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        bt(res, n, board, new ArrayList<>(), 0);
        return res;
    }
    private void bt(List<List<String>> res, int n, boolean[][] board, ArrayList<String> tmp, int row) {
        for (int i = 0; i < n; i++) {
            if (!board[row][i]) {
                boolean[][] temp = new boolean[n][n];
                for (int j = 0; j < n; j++) temp[j] = Arrays.copyOf(board[j], n);
                placeQueen(row, i, tmp, board);
                placeNextQueen(row, n, res, tmp, board);
                tmp.remove(tmp.size() - 1);
                board = temp;
            }
        }
    }
    private void placeQueen(int row, int column, ArrayList<String> tmp, boolean[][] board) {
        StringBuilder oneQueen = new StringBuilder();
        for (int i = 0; i < board.length; i++) oneQueen.append((i == column ? "Q" : "."));
        tmp.add(oneQueen.toString());
        for (int i = row + 1; i < board.length; i++) {
            board[i][column] = true;
            if (column + i - row < board.length) board[i][column + i - row] = true;
            if (column - i + row >= 0) board[i][column - i + row] = true;
        }
    }
    private void placeNextQueen(int row, int n, List<List<String>> res, ArrayList<String> tmp, boolean[][] board) {
        if (row == n - 1) {
            if (tmp.size() == n) res.add(new ArrayList<>(tmp));
            return;
        }
        bt(res, n, board, tmp, row + 1);
    }

    @Test
    public void testSolveNQueen() {
        for (List<String> list : solveNQueens(5)) {
            System.out.println(list);
        }
        System.out.println(solveNQueens(5).size());
    }

    // powcai
    public List<List<String>> solveNQueens1(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> z_diagonal = new HashSet<>();
        Set<Integer> f_diagonal = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        backtrack(0, n, res, new ArrayList<String>(), col, z_diagonal, f_diagonal);
        return res;


    }

    private void backtrack(int i, int n, List<List<String>> res, ArrayList<String> tmp, Set<Integer> col, Set<Integer> z_diagonal, Set<Integer> f_diagonal) {
        if (i == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col.contains(j) && !z_diagonal.contains(i + j) && !f_diagonal.contains(i - j)) {
                col.add(j);
                z_diagonal.add(i + j);
                f_diagonal.add(i - j);
                char[] s = new char[n];
                Arrays.fill(s, '.');
                s[j] = 'Q';
                tmp.add(new String(s));
                backtrack(i+1,n,res,tmp,col,z_diagonal,f_diagonal);
                tmp.remove(tmp.size() - 1);
                col.remove(j);
                z_diagonal.remove(i + j);
                f_diagonal.remove(i - j);
            }
        }
    }
}
