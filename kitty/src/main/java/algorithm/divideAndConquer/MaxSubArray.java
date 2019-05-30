package algorithm.divideAndConquer;

import org.junit.Test;

/**
 * 53.最大子序和
 */
public class MaxSubArray {
    // 动态规划
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, res = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(dp[i], res);
        }
        return res;
    }

    @Test
    public void maxSubArrayTest() {
        System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    // 分治
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArrayDC(nums, 0, nums.length - 1);
    }
    private int maxSubArrayDC(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right) / 2;
        int tmp = Math.max(maxSubArrayDC(nums, left, mid), maxSubArrayDC(nums, mid + 1, right));
        return Math.max(tmp, maxSubArrayCross(nums, left, mid, right));
    }
    private int maxSubArrayCross(int[] nums, int left, int mid, int right) {
        int leftSum = nums[mid], rightSum = nums[mid + 1];
        int tmp = leftSum;
        for (int i = mid - 1; i >= left; i--) {
            tmp += nums[i];
            leftSum = Math.max(tmp, leftSum);
        }
        tmp = rightSum;
        for (int i = mid + 2; i <= right; i++) {
            tmp += nums[i];
            rightSum = Math.max(tmp, rightSum);
        }
        return leftSum + rightSum;
    }
}
