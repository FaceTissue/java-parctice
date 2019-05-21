package algorithm.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32.最长有效括号
 */
public class LongestValidParentheses {
    // my solution(会超时*_*!)
    public int longestValidParenthesis(String s) {
        if (s == null || s.length() < 2) return 0;
        int l = 0, r = s.length() - 1;
        while (l < s.length() && '(' != s.charAt(l)) l++;
        while (r >= 0 && ')' != s.charAt(r)) r--;
        if (l > r) return 0;
        else {
//            if (((r - l) & 1) == 0) {
//                return Math.max(longestValidParenthesis(s.substring(l, r)), longestValidParenthesis(s.substring(l + 1, r + 1)));
//            }
            int balance = 0;
            for (int i = l; i <= r; i++) {
                if (s.charAt(i) == '(') balance++;
                else balance--;
                if (balance < 0) break;
            }
            if (balance == 0) {
                return r - l + 1;
            } else {
                return Math.max(longestValidParenthesis(s.substring(l, r)), longestValidParenthesis(s.substring(l + 1, r + 1)));
            }
        }
    }

    // dp 方法
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 栈数据结构
    public int longestValidParentheses1(String s) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}
