package algorithm.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 46.全排列
 */
public class Permute {
    // 第一种回溯实现
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        back_tack(nums, res, new ArrayList<>(), new int[nums.length]);
        return res;
    }
    public void back_tack(int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp_list, int[] visited) {
        if (tmp_list.size() == nums.length) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                tmp_list.add(nums[i]);
                visited[i] = 1;
                back_tack(nums, res, tmp_list, visited);
                tmp_list.remove(tmp_list.size() - 1);
                visited[i] = 0;
            }
        }
    }

    // 第二种回溯实现
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        ArrayList<Integer> nums_lst = new ArrayList<>();
        for (int num : nums) nums_lst.add(num);
        backtrack(nums.length, nums_lst, output, 0);
        return output;
    }
    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n) {
            output.add(new ArrayList<>(nums));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }
}
