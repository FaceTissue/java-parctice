package mathematics;

/**
 * 31.下一个排列
 */
public class NextPermutation {
    // my solution
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int j = nums.length - 2;
        while (j >= 0 && nums[j] >= nums[j + 1]) j--;
        if (j == -1) insertionSort(nums, 0);
        else {
            int i = nums.length - 1;
            while (i > j && nums[i] <= nums[j]) i--;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            insertionSort(nums, j + 1);
        }
    }
    public void insertionSort(int[] arr, int start) {
        for (int i = start + 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= start && arr[j] > temp) arr[j + 1] = arr[j--];
            arr[j + 1] = temp;
        }
    }

    // official solution
    public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
