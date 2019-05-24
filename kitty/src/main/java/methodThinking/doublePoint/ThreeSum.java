package methodThinking.doublePoint;

import java.util.*;

/**
 * 15.三数之和
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (list.contains(num)) {
                if (map.containsKey(num)) map.put(num, map.get(num) + 1);
                else map.put(num, 2);
            } else {
                list.add(num);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int f = -list.get(i);
            Map<Integer, Integer> map1 = new HashMap<>();
            for (int j = i + 1; j < list.size(); j++) {
                int s = f - list.get(j);
                if (map1.containsKey(s)) result.add(Arrays.asList(list.get(i), list.get(j), s));
                map1.put(list.get(j), j);
            }
        }
        map.forEach((num, count) -> {
            if (num != 0 && list.contains(-2 * num)) {
                result.add(Arrays.asList(num, num, -2 * num));
            } else if (count >= 3 && num == 0) {
                result.add(Arrays.asList(0, 0, 0));
            }
        });
        return result;
    }

    /**
     * 1.将数组排序
     * 2.定义三个指针，i，j，k。遍历i，
     *   那么这个问题就可以转化为在i之后的数组中寻找nums[j]+nums[k]=-nums[i]这个问题，
     *   也就将三数之和问题转变为二数之和---（可以使用双指针）
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1, r = nums.length - 1, sum = -nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        r--;
                        l++;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return result;
    }

    // 回溯算法(会超时)
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        bt(res, nums, 0, new ArrayList<>(), 0);
        return res;
    }
    public void bt(List<List<Integer>> res, int[] nums, int pos, ArrayList<Integer> tmp, int target) {
        if (tmp.size() == 3) {
            if (target == 0) res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (i == pos || nums[i] != nums[i - 1]) {
                tmp.add(nums[i]);
                bt(res, nums, i + 1, tmp, target - nums[i]);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
