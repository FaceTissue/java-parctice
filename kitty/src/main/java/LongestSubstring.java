public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        int res = 0, i = 0, n = s.length();
        while (i + k <= n) {
            int m[] = new int[26], max_idx = i, mark = 0;
            for (int j = i; j < n; j++) {
                int p = s.charAt(j) - 'a';
                ++m[p];
                if (m[p] < k) mark |= 1 << p;
                else mark &= ~(1 << p);
                if (mark == 0) {
                    res = Math.max(res, j - i + 1);
                    max_idx = j;
                }
            }
            i = max_idx + 1;
        }
        return res;
    }
}
