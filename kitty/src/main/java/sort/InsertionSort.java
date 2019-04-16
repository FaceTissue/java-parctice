package sort;

import org.junit.Test;

import java.util.Arrays;

public class InsertionSort extends IArraySort {
    @Override
    int[] sort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j--];
            }
            arr[j+1] = temp;
        }
        return arr;
    }

    private int[] binaryInsertionSort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);
        for (int i = 1; i < n; i++) {
            int p = 0, q = i - 1, temp = arr[i];
            while (p <= q) {
                int half = (p + q) / 2;
                if (arr[i] < arr[half]) q = half - 1;
                else if (arr[i] > arr[half]) p = half + 1;
            }
            if (i - p > 0) System.arraycopy(arr, p, arr, p + 1, i - p);
            arr[p] = temp;
        }
        return arr;
    }

    @Test
    public void test() {
        int[] sourceArray = {5, 4, 3, 2, 1};
//        System.arraycopy(sourceArray, 0, sourceArray, 1, 1);
        System.out.println(Arrays.toString(sourceArray));
        System.out.println(Arrays.toString(sort(sourceArray)));
        System.out.println(Arrays.toString(binaryInsertionSort(sourceArray)));
    }
//    int j = 0;
//    int temp = arr[j];
//            for (; j < i; j++) {
//        if (arr[i] < arr[j]) {
//            temp = arr[i];
//            break;
//        }
//    }
//            if (i - j >= 0) System.arraycopy(arr, j, arr, j + 1, i - j);
//    arr[j] = temp;
}
