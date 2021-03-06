package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class HeapSort extends IArraySort {
    @Override
    int[] sort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);
        buildMaxHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (len - 2) / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int p, int len) {
        int temp = arr[p];
        for (int i = 2 * p + 1; i < len; i = 2 * i + 1) {
            if (i + 1 < len && arr[i+1] > arr[i]) {
                i++;
            }
            if (arr[i] > temp) {
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
