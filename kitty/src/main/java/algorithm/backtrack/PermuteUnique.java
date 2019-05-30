package algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47.全排列Ⅱ
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        permuteUnique_backTrack(res, nums, new int[nums.length], new ArrayList<>());
        return res;
    }

    public void permuteUnique_backTrack(List<List<Integer>> res, int[] nums, int[] visited, ArrayList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            if (i == 0 || nums[i] != nums[i - 1] || (visited[i] == 0 && visited[i - 1] == 1)) {
                tmp.add(nums[i]);
                visited[i] = 1;
                permuteUnique_backTrack(res, nums, visited, tmp);
                visited[i] = 0;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    @Test
    public void test() {
        for (List<Integer> list : permuteUnique(new int[]{2, 2, 1, 1})) {
            System.out.println(list);
        }
    }
}
