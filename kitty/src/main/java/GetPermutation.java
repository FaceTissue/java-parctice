import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {
    // 有点贪心的意思
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) dp[i] = dp[i - 1] * i;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (k > dp[i]) {
                int pick = (k - 1) / dp[i] + 1;
                res.append(list.get(pick - 1));
                k -= (pick - 1) * dp[i];
                list.remove(pick - 1);
            } else {
                res.append(list.get(0));
                list.remove(0);
            }
        }
        return res.toString();
    }
    public String getPermutationOptimize(int n, int k) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) dp[i] = dp[i - 1] * i;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int pick = k > dp[i] ? (k - 1) / dp[i] : 0;
            res.append(list.get(pick));
            k -= pick * dp[i];
            list.remove(pick);
        }
        return res.toString();
    }

    // powcai
    public String getPermutation1(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) factorial[i] = i * factorial[i-1];
        n--;
        StringBuilder res = new StringBuilder();
        while (n >= 0){
            int t = factorial[n];
            int loc = (int) (Math.ceil((double) k / (double) t)) - 1;
            if (loc == -1) loc = num.size() - 1;
            res.append(num.get(loc));
            num.remove(loc);
            k %= t;
            n--;
        }
        return res.toString();
    }

    @Test
    public void getPermutationTest() {
        System.out.println(getPermutationOptimize(4, 18));
        System.out.println((int) Math.ceil(5.0 / 6.0));
    }
}
