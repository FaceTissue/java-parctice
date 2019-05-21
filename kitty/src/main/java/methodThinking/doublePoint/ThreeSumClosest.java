package methodThinking.doublePoint;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        if (nums.length <= 3) {
            for (int num : nums) ans += num;
            return ans;
        }
        Arrays.sort(nums);
        int flag = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < flag) {
                    ans = sum;
                    flag = Math.abs(target - sum);
                }
                if (sum == target) return ans;
                else if (sum < target) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                }
                else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
            }
        }
        return ans;
    }
}
