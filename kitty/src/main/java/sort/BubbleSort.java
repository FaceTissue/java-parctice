package sort;

import org.junit.Test;

import java.util.Arrays;

public class BubbleSort extends IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);
        for (int i = 0; i < n - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
        return arr;
    }

    @Test
    public void test() {
        int[] sourceArray = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(sort(sourceArray)));
    }
}
