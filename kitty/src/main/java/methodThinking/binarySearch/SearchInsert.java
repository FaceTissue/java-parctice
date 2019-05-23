package methodThinking.binarySearch;

import org.junit.Test;

/**
 * 35. 搜索插入位置
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums[l] >= target) return l;
        else return l + 1;
    }
    public int searchInsert1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
    @Test
    public void test() {
        System.out.println(searchInsert1(new int[]{7, 8, 9}, 7));
    }
}
