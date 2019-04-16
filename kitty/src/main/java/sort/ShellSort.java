package sort;

import org.junit.Test;

import java.util.Arrays;

public class ShellSort extends IArraySort {
    @Override
    int[] sort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i], j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    @Test
    public void test() {
        int[] sourceArray = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        sort(sourceArray);
    }
}
