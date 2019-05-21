package methodThinking.doublePoint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int f = target - nums[i];
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int l = j + 1, r = nums.length - 1, s = f - nums[j];
                        while (l < r) {
                            if (nums[l] + nums[r] == s) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) l++;
                                while (l < r && nums[r] == nums[r - 1]) r--;
                                l++;
                                r--;
                            } else if (nums[l] + nums[r] < s) {
                                while (l < r && nums[l] == nums[l + 1]) l++;
                                l++;
                            } else {
                                while (l < r && nums[r] == nums[r - 1]) r--;
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = fourSum(nums, -1);
        for (List<Integer> list : lists) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
