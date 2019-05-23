package algorithm.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40.组合总和Ⅱ
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, res, new ArrayList<>());
        return res;
    }
    public void backTrack(int[] candidates, int target, int start, List<List<Integer>> res, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            tmp_list.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, res, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }
}
