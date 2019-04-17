package sort;

import org.junit.Test;

import java.util.Arrays;

public class MinHeapSort extends IArraySort {
    @Override
    int[] sort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);
        buildMinHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, i);
        }

        return arr;
    }

    private void buildMinHeap(int[] arr, int n) {
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    private void heapify(int[] arr, int p, int n) {
        int temp = arr[p];
        for (int i = 2 * p + 1; i < n; i = 2 * i + 1) {
            if (i + 1 < n && arr[i] > arr[i+1]) {
                i++;
            }
            if (arr[i] < temp) {
                arr[p] = arr[i];
                p = i;
            }
        }
        arr[p] = temp;
    }

    @Test
    public void test() {
        int[] sourceArray = {87,45,78,32,17,65,53,9,122};
        System.out.println(Arrays.toString(sort(sourceArray)));
    }
}
