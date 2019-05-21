package methodThinking.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {
    public List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (start >= nums.length) return res;
        if (k == 2) {
            int l = start, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(Arrays.asList(nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
            }
        }
        if (k > 2) {
            for (int i = 0; i < nums.length; i++) {
                List<List<Integer>> tmp = kSum(nums, target - nums[i], k - 1, i + 1);
                for (List<Integer> list : tmp) list.add(nums[i]);
                res.addAll(tmp);

                while (i < nums.length && nums[i] == nums[i + 1]) i++;
            }
            return res;
        }
        return res;
    }
}
