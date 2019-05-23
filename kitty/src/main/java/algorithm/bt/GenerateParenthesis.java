package algorithm.bt;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生成
 */
public class GenerateParenthesis {
    /**
     * my solution
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n > 0) generate(res, n - 1, n, new StringBuilder("("));
        return res;
    }

    public void generate(List<String> res, int open, int close, StringBuilder sb) {
        if (open == 0) {
            while (close > 0) {
                sb.append(")");
                close--;
            }
            res.add(sb.toString());
            return;
        }
        generate(res, open - 1, close, new StringBuilder(sb.toString()).append("("));
        if (close > open) generate(res, open, close - 1, new StringBuilder(sb.toString()).append(")"));
    }

    /**
     * 暴力法
     */
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        generateAll(new char[2 * n], 0, ans);
        return ans;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (current.length == pos) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }


    /**
     * 回溯算法
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backTrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == 2 * max) {
            ans.add(cur);
            return;
        }
        if (open < max) backTrack(ans, cur + "(", open + 1, close, max);
        if (close < open) backTrack(ans, cur + ")", open, close + 1, max);
    }

    /**
     * 闭合数
     */
    public List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                for (String left : generateParenthesis3(c))
                    for (String right : generateParenthesis3(n - 1 - c))
                        ans.add("(" + left + ")" + right);
//                        ans.add(left + "(" + right + ")");
//                        ans.add("(" + left + right + ")");
//                        ans.add("(" + ")" + left + right);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(generateParenthesis3(3));
    }
}

