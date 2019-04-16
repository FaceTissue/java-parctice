package sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort extends IArraySort {
    // 贪心分治动态规划回溯枚举
    @Override
    int[] sort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);
        return quickSort(arr, 0, n - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[left];
            int index = left;
            for (int i = index + 1; i <= right; i++) {
                if (arr[i] < pivot) {
                    int temp = arr[++index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                }
            }
            arr[left] = arr[index];
            arr[index] = pivot;
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
        return arr;
    }

    @Test
    public void test() {
        int[] sourceArray = {3, 4, 2, 5, 1};
        System.out.println(Arrays.toString(quickSort(sourceArray, 0, sourceArray.length - 1)));
    }
}
