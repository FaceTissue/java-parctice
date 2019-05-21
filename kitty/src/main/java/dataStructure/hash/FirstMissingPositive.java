package dataStructure.hash;

/**
 * 41.缺失的第一个正数
 */
public class FirstMissingPositive {
    // my solution, incorrect
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int max = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > 0 && num < min) min = num;
            if (num > max) max = num;
        }
        if (min == 1) {
            if (min < max) {
                int i = 2;
                while (i <= max){
                    boolean flag = true;
                    for (int num : nums) {
                        if (num == i) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) return i;
                    i++;
                }
                return i;
            } else {
                return 2;
            }
        }
        return 1;
    }

    // powcai, incorrect
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
                swap(nums, nums[i] - 1, i);
        }
        int i = 0;
        while (i < n && nums[i] == i + 1) i++;
        return i + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // official
    /**
     * 现在可以开始写算法了。
     *
     * ·检查 1 是否存在于数组中。如果没有，则已经完成，1 即为答案。
     * ·如果 nums = [1]，答案即为 2 。
     * ·将负数，零，和大于 n 的数替换为 1 。
     * ·遍历数组。当读到数字 a 时，替换第 a 个元素的符号。 注意重复元素：只能改变一次符号。由于没有下标 n ，使用下标 0 的元素保存是否存在数字 n。
     * ·再次遍历数组。返回第一个正数元素的下标。Walk again along the array. Return the index of the first positive element.
     * ·如果 nums[0] > 0，则返回 n 。
     * ·如果之前的步骤中没有发现 nums 中有正数元素，则返回n + 1
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length, contains = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0) return 1;
        if (n == 1) return 2;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if (a == n) nums[0] = -Math.abs(nums[0]);
            else nums[a] = -Math.abs(nums[a]);
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) return n;
        return n + 1;
    }
}
