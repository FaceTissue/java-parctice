package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class SelectionSort extends IArraySort {
    @Override
    int[] sort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);
        for (int i = 0; i < n - 1; i++) {
            int min = arr[i], pos = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    pos = j;
                }
            }
            if (min < arr[i]) {
                arr[pos] = arr[i];
                arr[i] = min;
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
