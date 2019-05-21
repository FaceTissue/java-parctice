package methodThinking.doublePoint;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[idx]) {
                int tmp = nums[++idx];
                nums[idx] = nums[i];
                nums[i] = tmp;
            }
        }
        return idx + 1;
    }
}
