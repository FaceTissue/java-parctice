package methodThinking.binarySearch;

/**
 * 34.在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] fastFail = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return fastFail;
        if (target < nums[0] || target > nums[nums.length - 1]) return fastFail;
        int[] res = new int[2];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums[l] == target) res[0] = l;
        else return fastFail;
        r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                if (nums[r] == target) l = mid + 1;
                else {
                    l = mid;
                    r--;
                }
            }
            else r = mid - 1;
        }
        res[1] = l;
        return res;
    }
}
