package methodThinking.doublePoint;

public class RemoveElement {
    // 双指针
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
    // 双指针-当要删除的元素很少时
    public int removeElement1(int[] nums, int val) {
        int l = 0, r = nums.length;
        while (l < r) {
            if (nums[l] == val) {
                nums[l] = nums[--r];
            } else {
                l++;
            }
        }
        return r;
    }
}
