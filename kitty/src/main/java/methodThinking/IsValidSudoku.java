package methodThinking;

import java.util.HashMap;

/**
 * 36. 是否有效的数独
 */
public class IsValidSudoku {
    // 三次遍历
    public boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            int[] count = new int[9];
            for (char c : chars) {
                if (c != '.') {
                    count[c - '1']++;
                    if (count[c - '1'] > 1) return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            int[] count = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    count[board[j][i] - '1']++;
                    if (count[board[j][i] - '1'] > 1) return false;
                }
            }
        }
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                int[] count = new int[9];
                for (int p = i; p < i + 3; p++) {
                    for (int q = j; q < j + 3; q++) {
                        if (board[p][q] != '.') {
                            count[board[p][q] - '1']++;
                            if (count[board[p][q] - '1'] > 1) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // 一次遍历
    public boolean isValidSudoku1(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                int n = (int) num;
                int box_index = (i / 3) * 3 + j / 3;

                rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
