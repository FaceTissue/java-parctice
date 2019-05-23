package algorithm.bt;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39.组合总和
 */
public class CombinationSum {
    // my solution, 递归
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        return combinate(candidates, 0, candidates.length - 1, target);
    }
    public List<List<Integer>> combinate(int[] candidates, int start, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (end - start == 0) {
            if (target != 0 && target % candidates[start] == 0) {
                List<Integer> one = new ArrayList<>();
                for (int i = 0; i < target / candidates[start]; i++) one.add(candidates[start]);
                res.add(one);
            }
        } else {
            res.addAll(combinate(candidates, start, end - 1, target));
            res.addAll(combinate(candidates, end, end, target));
            int j = 1;
            while (j * candidates[end] < target) {
                for (List<Integer> ans : combinate(candidates, start, end - 1, target - candidates[end] * j)) {
                    for (int k = j; k > 0; k--) ans.add(candidates[end]);
                    res.add(ans);
                }
                j++;
            }
        }
        return res;
    }

    // backtrack

    /**
     * 回溯算法的一般步骤：
     * 1.定义解空间
     * 2.确定易于搜索的解空间结构
     * 3.以深度优先的方式搜索解空间，同时使用剪枝函数避免无效搜索
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }
    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            tmp_list.add(candidates[start]);
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

    @Test
    public void test() {
        combinationSum1(new int[]{2, 3, 6, 7}, 7);
    }
}
